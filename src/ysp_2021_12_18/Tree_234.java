package ysp_2021_12_18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Tree_234 {
	public static void main(String[] args) {
		Tree234<String, Integer> st = new Tree234<>();
		Scanner sc = new Scanner(System.in);	
		System.out.print("입력 파일 이름? ");
		String fname = sc.nextLine();	
		System.out.print("난수 생성을 위한 seed 값? ");
		long seed = sc.nextLong();
		Random rand = new Random(seed);
		sc.close();
		try {
			sc = new Scanner(new File(fname));
			long start = System.currentTimeMillis();
			while (sc.hasNext()) {
				String word = sc.next();
				if (!st.contains(word))
					st.put(word, 1);
				else	st.put(word, st.get(word) + 1);
			}
			long end = System.currentTimeMillis();
			System.out.println("입력 완료: 소요 시간 = " + (end-start) + "ms");
			
			System.out.println("### 생성 시점의 트리 정보");
			print_tree(st);
			
			ArrayList<String> keyList = (ArrayList<String>) st.keys();
			int loopCount = (int)(keyList.size() * 0.95);
			for (int i = 0; i < loopCount; i++) {
				int deletedIndex = rand.nextInt(keyList.size());
				String key = keyList.get(deletedIndex);
				st.delete(key);									
				keyList.remove(deletedIndex);
			}
			System.out.println("\n### 키 삭제 후 트리 정보");			
			print_tree(st);										
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		if (sc != null)
			sc.close();
	}
	
	private static void print_tree(Tree234<String, Integer> st) {
		System.out.println("등록된 단어 수 = " + st.size());		
		System.out.println("트리의 깊이 = " + st.depth());		
		
		String maxKey = "";
		int maxValue = 0;
		for (String word : st.keys())
			if (st.get(word) > maxValue) {
				maxValue = st.get(word);
				maxKey = word;
			}
		System.out.println("가장 빈번히 나타난 단어와 빈도수: " + maxKey + " " + maxValue);
	}
}

class Tree234Node<K extends Comparable<K>, V> {
    private ArrayList<K> keys = new ArrayList<>();
    private ArrayList<V> values = new ArrayList<>();
    private ArrayList<Tree234Node<K, V>> children = new ArrayList<>();

    public Tree234Node() {
        for (int i = 0; i < 3; i++) {
            keys.add(null);
            values.add(null);
        }
        for (int i = 0; i < 4; i++) {
            children.add(null);
        }
    }

    public boolean isLeaf() {
        return getChild(0) == null;
    }

    public boolean is4Node() {
        return getKey(2) != null;
    }

    public boolean isEmpty() {
        return getKey(0) == null;
    }

    public boolean is2Node() {
        return (getKey(0) != null) && (getKey(1) == null);
    }

    public void insert(Tree234Node<K, V> node2) {
        ArrayList<K> keys = new ArrayList<>();
        ArrayList<V> values = new ArrayList<>();
        ArrayList<Tree234Node<K, V>> children = new ArrayList<>();

        boolean node2flag = false;
        for (int idx = 0; idx < 3; idx++) {
            if (getKey(idx) == null) break;
            if ( !node2flag && node2.getKey(0).compareTo( getKey(idx) ) < 0 ) {
                keys.add( node2.getKey(0) );
                values.add( node2.getValue(0) );
                children.add( node2.getChild(0) );
                children.add( node2.getChild(1) );
                node2flag = true;
            }

            keys.add( getKey(idx) );
            values.add( getValue(idx) );
            if (!node2flag) children.add( getChild(idx) );
            else children.add( getChild(idx+1) );
        }

        if (!node2flag) {
            keys.add( node2.getKey(0) );
            values.add( node2.getValue(0) );
            children.add( node2.getChild(0) );
            children.add( node2.getChild(1) );
        }

        for (int i = 0; i < keys.size(); i++) setKey(i, keys.get(i));
        for (int i = 0; i < values.size(); i++) setValue(i, values.get(i));
        for (int i = 0; i < children.size(); i++) setChild(i, children.get(i));
    }

    public void erase(K key) {
        for (int idx = 0; idx < 3; idx++) {
            if ( key.compareTo(getKey(idx) ) == 0 ) {
                setKey(idx, null);
                setValue(idx, null);
                break;
            }
        }

        for (int idx = 1; idx < 3; idx++) {
            if ( getKey(idx-1) == null ) {
                setKey(idx-1, getKey(idx));
                setValue(idx-1, getValue(idx));

                setKey(idx, null);
                setValue(idx, null);
            }
        }
    }

    public ArrayList<K> keys() {
        ArrayList<K> result = new ArrayList<>();

        int idx = 0;
        for (; idx < 3; idx++) {
            if (getKey(idx) == null) break;
            if (!isLeaf()) result.addAll( getChild(idx).keys() );
            result.add( getKey(idx) );
        }
        if (!isLeaf()) result.addAll( getChild(idx).keys() );

        return result;
    }

    public void setKey(int idx, K key) {
        keys.set(idx, key);
    }

    public void setValue(int idx, V value) {
        values.set(idx, value);
    }

    public void setChild(int idx, Tree234Node<K, V> child) {
        children.set(idx, child);
    }

    public K getKey(int idx) {
        return keys.get(idx);
    }

    public V getValue(int idx) {
        return values.get(idx);
    }

    public Tree234Node<K, V> getChild(int idx) {
        return children.get(idx);
    }

    public void debug() {
        System.out.println("--- DEBUG ---");
        System.out.print("KEY: ");
        for (K k : keys) System.out.print(k + "\t");
        System.out.println();
        System.out.print("VAL: ");
        for (V v : values) System.out.print(v + "\t");
        System.out.println('\n');

        System.out.println("CHILD's KEY: ");
        for (Tree234Node<K, V> child : children) {
            if (child != null) for (K k : child.keys) System.out.print(k + " ");
            else System.out.print("null ");
            System.out.println();
        }
        System.out.println("\n");
    }
}

class Tree234<K extends Comparable<K>, V> {
    private Tree234Node<K, V> root;
    private int size = 0;
    private int depth = 0;
    
    public Tree234() {
        root = new Tree234Node<>();
    }

    protected Tree234Node<K, V> split(Tree234Node<K, V> node4, Tree234Node<K, V> node2) {
        ArrayList<K> keys = new ArrayList<>();
        ArrayList<V> values = new ArrayList<>();
        ArrayList<Tree234Node<K, V>> children = new ArrayList<>();

        boolean node2flag = false;
        for (int idx = 0; idx < 3; idx++) {
            if ( !node2flag && node2.getKey(0).compareTo( node4.getKey(idx) ) < 0 ) {
                keys.add( node2.getKey(0) );
                values.add( node2.getValue(0) );
                children.add( node2.getChild(0) );
                children.add( node2.getChild(1) );
                node2flag = true;
            }
            
            keys.add( node4.getKey(idx) );
            values.add( node4.getValue(idx) );
            if (!node2flag) children.add( node4.getChild(idx) );
            else children.add( node4.getChild(idx+1) );
        }

        if (!node2flag) {
            keys.add( node2.getKey(0) );
            values.add( node2.getValue(0) );
            children.add( node2.getChild(0) );
            children.add( node2.getChild(1) );
        }

        Tree234Node<K, V> mid = new Tree234Node<>();
        Tree234Node<K, V> left = new Tree234Node<>();
        Tree234Node<K, V> right = new Tree234Node<>();

        left.setKey(0, keys.get(0));
        left.setKey(1, keys.get(1));
        mid.setKey(0, keys.get(2));
        right.setKey(0, keys.get(3));

        left.setValue(0, values.get(0));
        left.setValue(1, values.get(1));
        mid.setValue(0, values.get(2));
        right.setValue(0, values.get(3));

        left.setChild(0, children.get(0));
        left.setChild(1, children.get(1));
        left.setChild(2, children.get(2));
        right.setChild(0, children.get(3));
        right.setChild(1, children.get(4));

        mid.setChild(0, left);
        mid.setChild(1, right);

        return mid;
    }

    public void put(K key, V value) {
        Tree234Node<K, V> current = root;
        Stack<Tree234Node<K, V>> stack = new Stack<>();

        while (current != null) {
            stack.push(current);
            int idx = 0;
            for (; idx < 3; idx++) {
                if ( current.getKey(idx) == null || key.compareTo( current.getKey(idx) ) < 0 ) break;
                if ( key.compareTo( current.getKey(idx) ) == 0 ) {
                    current.setValue(idx, value);
                    return;
                }
            }
            current = current.getChild(idx);
        }
        if (current != root) current = stack.pop();

        size++;
        Tree234Node<K, V> mid = new Tree234Node<>();
        mid.setKey(0, key);
        mid.setValue(0, value);

        if (size == 1) {
            depth++;
        }

        while ( current.is4Node() ) {
            if ( current == root ) {
                root = split(current, mid);
                depth++;
                return;
            }

            mid = split(current, mid);
            current = stack.pop();
        }

        current.insert(mid);
    }

    public V get(K key) {
        Tree234Node<K, V> current = root;

        while (current != null) {
            int idx = 0;
            for (; idx < 3; idx++) {
                if ( current.getKey(idx) == null || key.compareTo( current.getKey(idx) ) < 0 ) break;
                if ( key.compareTo( current.getKey(idx) ) == 0 ) return current.getValue(idx);
            }
            current = current.getChild(idx);
        }
        
        return null;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public ArrayList<K> keys() {
        return root.keys();
    }

    public int size() {
        return size;
    }

    public int depth() {
        return depth;
    }

    public void delete(K key) {
        Tree234Node<K, V> current = root;
        Tree234Node<K, V> target = null;
        Stack<Tree234Node<K, V>> stack = new Stack<>();
        size--;

        if (size == 0) {
            depth--;
        }

        while (current != null) {
            stack.push(current);
            int idx = 0;
            for (; idx < 3; idx++) {
                if (current.getKey(idx) == null) break;
                if (key.compareTo( current.getKey(idx) ) == 0) {
                    target = current;
                    idx++;
                    break;
                }
                if (key.compareTo( current.getKey(idx) ) < 0) {
                    break;
                }
            }
            current = current.getChild(idx);
        }
        current = stack.pop();

        if (target != current && target != null) {
            for (int i = 0; i < 3; i++) {
                if (key.compareTo( target.getKey(i) ) == 0) {
                    target.setKey(i, current.getKey(0));
                    target.setValue(i, current.getValue(0));
                    key = current.getKey(0);
                    break;
                }
            }
        } 
        current.erase(key);

        while (current.getKey(0) == null) {
            if (current == root) {
                if (root.getChild(0) != null) {
                    root = root.getChild(0);
                    depth--;
                }

                return;
            }

            Tree234Node<K, V> parent = stack.pop();
            Tree234Node<K, V> left = null;
            Tree234Node<K, V> right = null;

            int curIdx = 0;
            for (; curIdx < 4; curIdx++) {
                if (parent.getChild(curIdx) == current) break;
            }

            if (curIdx-1 >= 0 && parent.getChild(curIdx-1) != null) left = parent.getChild(curIdx-1);
            if (curIdx+1 < 4 && parent.getChild(curIdx+1) != null) right = parent.getChild(curIdx+1);

            if (right != null && right.getKey(1) != null) {
                current.setKey( 0, parent.getKey(curIdx) );
                current.setValue( 0, parent.getValue(curIdx) );
                current.setChild( 1, right.getChild(0) );

                parent.setKey( curIdx, right.getKey(0) );
                parent.setValue( curIdx, right.getValue(0) );

                right.erase( right.getKey(0) );
                for (int i = 1; i < 4; i++) {
                    right.setChild( i-1, right.getChild(i) );
                }
                right.setChild(3, null);

                return;
            }
            else if (left != null && left.getKey(1) != null) {
                int lastIdx = 2;
                for (; lastIdx >= 0; lastIdx--) {
                    if (left.getKey(lastIdx) != null) break;
                }

                current.setKey( 0, parent.getKey(curIdx-1) );
                current.setValue( 0, parent.getValue(curIdx-1) );
                current.setChild( 1, current.getChild(0) );
                current.setChild( 0, left.getChild(lastIdx+1) );

                parent.setKey( curIdx-1, left.getKey(lastIdx) );
                parent.setValue( curIdx-1, left.getValue(lastIdx) );

                left.erase( left.getKey(lastIdx) );
                left.setChild( lastIdx+1, null );

                return;
            }
            else if (left != null) {
                left.setKey( 1, parent.getKey(curIdx-1) );
                left.setValue( 1, parent.getValue(curIdx-1) );
                left.setChild( 2, current.getChild(0) );

                parent.erase( parent.getKey(curIdx-1) );
                parent.setChild(curIdx, null);
                for (int i = curIdx+1; i < 4; i++) {
                    parent.setChild( i-1, parent.getChild(i) );
                    parent.setChild(i, null);
                }
            }
            else if (right != null) { 

                right.setKey( 1, right.getKey(0) );
                right.setValue( 1, right.getValue(0) );
                right.setChild( 2, right.getChild(1) );
                right.setChild( 1, right.getChild(0) );

                right.setKey( 0, parent.getKey(curIdx) );
                right.setValue( 0, parent.getValue(curIdx) );
                right.setChild( 0, current.getChild(0) );

                parent.erase( parent.getKey(curIdx) );
                parent.setChild(curIdx, null);
                for (int i = curIdx+1; i < 4; i++) {
                    parent.setChild( i-1, parent.getChild(i) );
                    parent.setChild(i, null);
                }
            }
            current = parent;
        }
    }

    public void rootDebug() {
        root.debug();
    }
}
