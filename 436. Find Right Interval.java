`Imagine you are organizing a series of events in a school, and each event has a start time and an end time. Each event is like a classroom session that has a start and an end time.

Goal
For each event, you want to find the next event that can start right after or exactly when the current event ends. If there is no such event, you should note that there is no suitable next event.

Characters in the Story
Events: Each event has a unique start time and an end time.
Next Event: The event that can start right after the current event ends.
Example
Let's take an example to make it clearer.

Example 1: Single Event
Event List: [[1, 2]]
Event 1: Starts at 1, ends at 2.
Question: What event starts at or after 2?
Answer: There is no such event because there is only one event.
Output: [-1]

Example 2: Multiple Events
Event List: [[3, 4], [2, 3], [1, 2]]
Event 1: Starts at 3, ends at 4.
Event 2: Starts at 2, ends at 3.
Event 3: Starts at 1, ends at 2.
Questions:

For Event 1 (3, 4): What event starts at or after 4?
Answer: There is no such event. Output: -1
For Event 2 (2, 3): What event starts at or after 3?
Answer: Event 1 (3, 4). Output: 0 (Event 1 is at index 0)
For Event 3 (1, 2): What event starts at or after 2?
Answer: Event 2 (2, 3). Output: 1 (Event 2 is at index 1)
Final Output: [-1, 0, 1]

Example 3: Overlapping Events
Event List: [[1, 4], [2, 3], [3, 4]]
Event 1: Starts at 1, ends at 4.
Event 2: Starts at 2, ends at 3.
Event 3: Starts at 3, ends at 4.
Questions:

For Event 1 (1, 4): What event starts at or after 4?
Answer: There is no such event. Output: -1
For Event 2 (2, 3): What event starts at or after 3?
Answer: Event 3 (3, 4). Output: 2 (Event 3 is at index 2)
For Event 3 (3, 4): What event starts at or after 4?
Answer: There is no such event. Output: -1
Final Output: [-1, 2, -1]

Breaking Down the Steps
Identify Each Event: List down each event with its start and end times.
Find the Next Event:
For each event, look for the event that starts at or after the end time of the current event.
Choose the event that starts the earliest among the possible options.
Note the Result:
If no such event exists, note -1.
If such an event exists, note the index of that event.`





int n = intervals.length;

        //start, OriginalIndex
        int[][] starts = new int[n][2];

        for(int i = 0; i<n; i++){
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        //sort by start value
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];

            int l = 0;
            int r = n - 1;
            int index = -1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (starts[mid][0] >= target) {
                    index = starts[mid][1];
                    r = mid - 1;     // Look for an even smaller valid start
                } else {
                    l = mid + 1;
                }
            }

            ans[i] = index;
        }

        return ans;
