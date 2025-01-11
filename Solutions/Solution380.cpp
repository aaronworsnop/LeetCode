class RandomizedSet
{
    std::vector<int> valueArray;
    std::map<int, int> indexMap;

public:
    RandomizedSet() {}

    bool insert(int val)
    {
        if (indexMap.contains(val))
        {
            return false;
        }
        else
        {
            indexMap[val] = valueArray.size();
            valueArray.push_back(val);
            return true;
        }
    }

    bool remove(int val)
    {
        if (!indexMap.contains(val))
        {
            return false;
        }
        else
        {
            // Swap to the end
            int index = indexMap[val];

            valueArray[index] = valueArray.back();
            indexMap[valueArray.back()] = index;

            // Remove last element
            valueArray.pop_back();
            indexMap.erase(val);
            return true;
        }
    }

    int getRandom()
    {
        int random = rand() % valueArray.size();
        return valueArray[random];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */