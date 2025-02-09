class MovieRentingSystem {
    TreeSet<Movie> rentedMovies; // Movies that HAVE BEEN rented, not necessarily currently rented.

    Map<Integer, Map<Integer, Movie>> shopMovieMap;
    Map<Integer, PriorityQueue<Movie>> movieShopByPriceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        this.rentedMovies = new TreeSet<>( 
                (movieA, movieB) -> {
                    if (movieB.price != movieA.price) {
                        return movieA.price - movieB.price;
                    } else if (movieB.shop != movieA.shop) {
                        return movieA.shop - movieB.shop;
                    } else {
                        return movieA.movie - movieB.movie;
                    }
                }
        );

        this.shopMovieMap = new HashMap<>();
        this.movieShopByPriceMap = new HashMap<>();

        for (int[] entry : entries) {
            Movie movie = new Movie(entry[1], entry[2], entry[0], false);

            Map<Integer, Movie> shopMovies = shopMovieMap.getOrDefault(entry[0], new HashMap<>());
            shopMovies.put(entry[1], movie);
            shopMovieMap.put(entry[0], shopMovies);

            PriorityQueue<Movie> movieShopsByPrice = movieShopByPriceMap.getOrDefault(entry[1], 
                new PriorityQueue<>( 
                        (movieA, movieB) -> {
                            if (movieB.price != movieA.price)
                            {
                                return movieA.price - movieB.price; 
                            } else {
                                return movieA.shop - movieB.shop;
                            }
                        })
                );
            movieShopsByPrice.offer(movie);
            movieShopByPriceMap.put(entry[1], movieShopsByPrice);
        }
    }
    
    public List<Integer> search(int movieNumber) {
        List<Integer> shops = new ArrayList<>();
        List<Movie> allMoviesConsidered = new ArrayList<>();

        PriorityQueue<Movie> shopByPrice = movieShopByPriceMap.get(movieNumber);
        if (shopByPrice == null) return shops;

        while (shops.size() < 5 && !shopByPrice.isEmpty()) {
            Movie movie = shopByPrice.poll();
            allMoviesConsidered.add(movie);

            if (!movie.rented) {
                // Movie is not rented
                shops.add(movie.shop);
            }
        }

        for (Movie movie : allMoviesConsidered) {
            shopByPrice.offer(movie);
        }
        movieShopByPriceMap.put(movieNumber, shopByPrice);

        return shops;
    }
    
    public void rent(int shop, int movieNumber) {
        Map<Integer, Movie> moviesAtShop = shopMovieMap.get(shop);

        if (moviesAtShop == null) return;

        Movie movie = moviesAtShop.get(movieNumber);
        movie.rented = true;

        rentedMovies.add(movie);
    }
    
    public void drop(int shop, int movieNumber) {
        Map<Integer, Movie> moviesAtShop = shopMovieMap.get(shop);
        
        if (moviesAtShop == null) return;

        Movie movie = moviesAtShop.get(movieNumber);
        movie.rented = false;
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> report = new ArrayList<>();
        List<Movie> reportMovies = new ArrayList<>();

        while (report.size() < 5 && !rentedMovies.isEmpty()) {
            Movie rentedMovie = rentedMovies.pollFirst();

            if (rentedMovie.rented) {
                // Movie is actually rented
                report.add(new ArrayList<Integer>(Arrays.asList(rentedMovie.shop, rentedMovie.movie)));
                reportMovies.add(rentedMovie);
            }
        }

        // Ensure our `rentedMovies` heap still contains all the rented movies AT LEAST. This function
        // actually removes some unrented movies, which is a positive side effect.
        for (Movie movie : reportMovies) {
            rentedMovies.add(movie);
        }

        return report;
    }

    class Movie {
        int movie;
        int price;
        int shop;

    	boolean rented;

        Movie(int movie, int price, int shop, boolean rented) {
            this.movie = movie;
            this.price = price;
            this.shop = shop;
            this.rented = rented;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            Movie otherMovie = (Movie) obj;
            return (
                this.movie == otherMovie.movie &&
                this.price == otherMovie.price &&
                this.shop == otherMovie.shop &&
                this.rented == otherMovie.rented
            );
        }

        @Override
        public int hashCode() {
            return Objects.hash(movie, price, shop, rented);
        }
    }
}
