class Solution
{
public:
    void merge(vector<int> &nums1, int m, vector<int> &nums2, int n)
    {

        // Edgecases
        if (nums1.empty() || nums2.empty())
        {
            return;
        }
        else if (m == 0)
        {
            nums1.assign(nums2.begin(), nums2.end());
            return;
        }
        else if (n == 0)
        {
            return;
        }

        // Traverse from the larger side for constant memory
        int leftPoint = m - 1;
        int rightPoint = n - 1;
        int index = m + n - 1;
        while (leftPoint >= 0 || rightPoint >= 0)
        {
            if (leftPoint < 0)
            {
                nums1[index] = nums2[rightPoint];
                rightPoint--;
            }
            else if (rightPoint < 0)
            {
                nums1[index] = nums1[leftPoint];
                leftPoint--;
            }
            else if (nums1[leftPoint] > nums2[rightPoint])
            {
                nums1[index] = nums1[leftPoint];
                leftPoint--;
            }
            else
            {
                nums1[index] = nums2[rightPoint];
                rightPoint--;
            }

            index--;
        }
    }
};