import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MinHeap mh = new MinHeap();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                System.out.println(mh.delete());
            } else {
                mh.insert(input);
            }
        }
    }

}

class MinHeap {
    List<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int val) {
        list.add(val);
        int p = list.size() - 1;
        while (p > 1 && list.get(p / 2) > list.get(p)) {
            int tmp = list.get(p / 2);
            list.set(p / 2, val);
            list.set(p, tmp);

            p /= 2;
        }
    }

    public int delete() {
        if (list.size() - 1 < 1) {
            return 0;
        }
        int deleteItem = list.get(1);
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentPos = 1;
        while (true) {
            int leftPos = currentPos * 2;
            int rightPos = currentPos * 2 + 1;

            //자식이 없는경우->자기가 leaf
            if (leftPos >= list.size()) {
                break;
            }
            int minValue = list.get(leftPos);
            int minPos = leftPos;
            if (rightPos < list.size() && list.get(rightPos) < minValue) {
                minValue = list.get(rightPos);
                minPos = rightPos;
            }
            if (list.get(currentPos) > minValue) {
                int temp = list.get(currentPos);
                list.set(currentPos, minValue);
                list.set(minPos, temp);
                currentPos = minPos;
            } else {
                break;
            }
        }
        return deleteItem;
    }
}
