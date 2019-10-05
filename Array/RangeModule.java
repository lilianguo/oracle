import java.util.Iterator;
import java.util.TreeSet;

/*

715. Range Module
https://leetcode.com/problems/range-module/ 

Time Complexity: Let K be the number of elements in ranges. 
addRange and removeRange operations have O(K) complexity. 
queryRange has O(logK) complexity. 
Because addRange, removeRange adds at most 1 interval at a time, you can bound these further. 
For example, if there are A addRange, R removeRange, and Q queryRange number of operations respectively, 
we can express our complexity as O((A+R)^2*Qlog(A+R))
Space Complexity: O(A+R)O(A+R), the space used by ranges
*/

class RangeModule {
    TreeSet<Interval> ranges;
    public RangeModule() {
        ranges = new TreeSet<>();
    }
    // 利用treeset是可以自定义排序，implement Comparable 
    // 排成 按right升序，如果right 相同，则按left升序
    /*
    如此： addRange(left, right)需要找到比（0，left - 1）>= 的interval 们
    removeRange(left, right) 需要找到 (0, left) > 的interval 们
    query则只需要比较set中的一个interval，它是第一个右边界比 left 大的interval， 如果这个interval不存在，或者
    input不是它的子集， 那说明不包含整个input
    */

    class Interval implements Comparable<Interval>{
        int left;
        int right;
        public Interval (int left, int right) {
            this.left = left;
            this.right = right;
        }
        public int compareTo(Interval that) {
            if (this.right == that.right) return this.left - that.left;
            return this.right - that.right;
        }
    }
    // The java.util.TreeSet.tailSet() method is used to set a point of start for a tree set, 
    // to return all the elements greater than the element passed as parameter mentioned to the method in a sorted manner 
    // including the element(if the element is mentioned in the tree).
    public void addRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left - 1)).iterator();
        while(itr.hasNext()) {
            Interval curr = itr.next();
            if (right < curr.left) {
                break;
            }
            left = Math.min(left, curr.left);
            right = Math.max(right, curr.right);
            itr.remove();
        }
        ranges.add(new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        /*
        The higher(E ele) method of TreeSet class in Java is used to return the least element in this set 
        which is strictly greater than the given element ele. If no such element is there then this method returns NULL
        Here, E is the type of element maintained by this TreeSet collection.
        */
        Interval interval = ranges.higher(new Interval(0, left));
        return interval != null && interval.right >= right && interval.left <= left;
    }

    public void removeRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
        ArrayList<Interval> toDo = new ArrayList<>();
        while(itr.hasNext()) {
            Interval curr = itr.next();
            if (right < curr.left) {
                break;
            }
            if (curr.left < left) {
                toDo.add(new Interval(curr.left, left));
            }
            if (curr.right > right) {
                toDo.add(new Interval(right, curr.right));
            }
            itr.remove();
        }
        for (Interval toBeAdded : toDo) {
            ranges.add(toBeAdded);
        }
    }
}