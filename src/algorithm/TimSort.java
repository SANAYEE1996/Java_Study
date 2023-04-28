package algorithm;

public class TimSort {

	private static final int THRESHOLD = 32;
	
	public int minRunLength(int runSize) {
 
		int r = 0;	// 홀 수가 발생할 때 2^x가 초과되지 않도록 하는 여분의 수
 
		while(runSize >= THRESHOLD) {
			r |= (runSize & 1);
			runSize >>= 1;
				
		}
		return runSize + r;
	}
	
	public void sort(int[] a) {
		sort(a, 0, a.length);
	}
	
	public void sort(int[] a, int lo, int hi) {
		
		int remain = hi - lo;
		// 정렬해야 할 원소가 1개 이하일 경우 정렬 할 필요가 없다.
		if(remain < 2) {
			return;
		}

		if(remain < THRESHOLD) {
			int increaseRange = getAscending(a, lo, hi);
			BinarySort(a, lo, hi, lo + increaseRange);
			return;
		}
		
		
		IntMergeStack ims = new IntMergeStack(a);
		int minRun = minRunLength(remain);	// run의 최소 길이
		do {
			
			/*
			 * 정렬 된 구간의 길이를 구한다. 
			 */
			int runLen = getAscending(a, lo, hi);
			

			if(runLen < minRun) {

				int counts = remain < minRun ? remain : minRun;

				BinarySort(a, lo, lo + counts, lo + runLen);
				
				runLen = counts;
			}
			ims.pushRun(lo, runLen);
			ims.merge();
			
			lo += runLen;
			remain -= runLen;
		} while(remain != 0);	// 정렬 해야 할 원소가 0개가 될 때 까지 반복
		ims.mergeForce();		// 마지막으로 스택에 있던 run들 모두 병합
 
	}
	
	private void BinarySort(int[] a, int lo, int hi ,int start) {
 
		if(lo == start) {
			start++;
		}
 
		for (; start < hi; start++) {
			int target = a[start];
 
			int loc = binarySearch(a, target, lo, start);
 
			int j = start - 1;
 
			while (j >= loc) {
				a[j + 1] = a[j];
				j--;
			}
 
			a[loc] = target;
		}
 
	}
	
	private int binarySearch(int[] a, int key, int lo, int hi) {
 
		int mid;
		while (lo < hi) {
			mid = (lo + hi) >>> 1;
			if (key < a[mid]) {
				hi = mid;
			} 
			else {
				lo = mid + 1;
			}
		}
		return lo;
	}
	
	private int getAscending(int[] a, int lo, int hi) {	
 
		int limit = lo + 1;
		if (limit == hi) { 
			return 1;
		}
 
		if (a[lo] <= a[limit]) {
			while (limit < hi && a[limit - 1] <= a[limit]) {
				limit++;
			}
		}
		else {
			while (limit < hi && a[limit - 1] > a[limit]) {
				limit++;
			}
			reversing(a, lo, limit);
		}
 
		return limit - lo;
	}
	
	private void reversing(int[] a, int lo, int hi) {
		hi--;
		while (lo < hi) {
			int temp = a[lo];
			a[lo++] = a[hi];
			a[hi--] = temp;
		}
	}
}

class IntMergeStack {
	
	private int[] array;
	private int[] runBase;
	private int[] runLength;
	private int stackSize = 0;	// run 스택의 원소 개수를 가리킬 변수
    
	public IntMergeStack(int[] a) {
		this.array = a;
		int len = a.length;

	
		runBase = new int[40];
		runLength = new int[40];
	}
    
	public void pushRun(int runBase, int runLen) {
		this.runBase[stackSize] = runBase;
		this.runLength[stackSize] = runLen;
		stackSize++;
	}
    
	public void mergeForce() {

		// 나머지 모든 run을 병합한다.
		while (stackSize > 1) {

			// 모든 run을 병합 할 것이기 때문에 2번 조건인 runLen[i - 2] > runLen[i - 1] 만 체크해주면서 병합한다.
			if (stackSize > 2 && runLength[stackSize - 3] < runLength[stackSize - 1]) {
				merge(stackSize - 3);
			} else {
				merge(stackSize - 2);
			}
		}
	}
    
    
    public void merge() {
		while (stackSize > 1) {
			if (stackSize > 2 && runLength[stackSize - 3] <= runLength[stackSize - 2] + runLength[stackSize - 1]
					|| stackSize > 3 && runLength[stackSize - 4] <= runLength[stackSize - 3] + runLength[stackSize - 2]) {

				if (runLength[stackSize - 3] < runLength[stackSize - 1]) {
					merge(stackSize - 3);
				} 
				else {
					merge(stackSize - 2);
				}
			}
			// 2번 조건 B > A 에 위배 될 경우 (== B <= A 일 경우)
			else if (runLength[stackSize - 2] <= runLength[stackSize - 1]) {
				merge(stackSize - 2);
			}
			// 그 외의 경우는 위 두 조건을 만족한다는 의미이므로 종료
			else {
				break;
			}
		}
	}
    
	private void merge(int idx) {

		int start1 = runBase[idx];
		int length1 = runLength[idx];
		int start2 = runBase[idx + 1];
		int length2 = runLength[idx + 1];

		runLength[idx] = length1 + length2;
    	
		if (idx == (stackSize - 3)) {
			runBase[idx + 1] = runBase[idx + 2];
			runLength[idx + 1] = runLength[idx + 2];
		}
		stackSize--;

		int lo = gallopRight(array[start2], array, start1, length1);

		if (length1 == lo) {
			return;
		}
    	start1 += lo;
    	length1 -= lo;
    	
		int hi = gallopLeft(array[start1 + length1 - 1], array, start2, length2);

		if (hi == 0) {
			return;
		}

		length2 = hi;
		if (length1 <= length2) {
			mergeLo(start1, length1, start2, length2);
		}
		else {
			mergeHi(start1, length1, start2, length2);
		}
	}
    
    private int gallopRight(int key, int[] array, int base, int lenOfA) {


    	int lo = 0;		// 이전 탐색(gallop) 지점
    	int hi = 1;		// 현재 탐색(gallop) 지점
    	
    	if(key < array[base]) {
    		return 0;
    	}
    	
    	else {
			int maxLen = lenOfA; // galloping을 하여 가질 수 있는 최대 한계값
			while (hi < maxLen && array[base + hi] <= key) {
				lo = hi;
				hi = (hi << 1) + 1;

				if (hi <= 0) { // overflow 발생시 run A의 끝 점으로 초기화
					hi = maxLen;
				}
			}

			if (hi > maxLen) {
				hi = maxLen;
			}
		}

		lo++;
		
		while (lo < hi) {
			int mid = lo + ((hi - lo) >>> 1);

			if (key < array[base + mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return hi;
    }
    
    private int gallopLeft(int key, int[] array, int base, int lenOfB) {

		int lo = 0;
		int hi = 1;

		if (key > array[base + lenOfB - 1]) {
			return lenOfB;
		}

		else {
			int startPointOfRun = base + lenOfB - 1;

			int maxLen = lenOfB; // galloping을 하여 가질 수 있는 최대 한계값

			while (hi < maxLen && key <= array[startPointOfRun - hi]) {
				lo = hi;
				hi = (hi << 1) + 1;

				if (hi <= 0) {
					hi = maxLen;
				}
			}

			if (hi > maxLen) {
				hi = maxLen;
			}

    		int temp = lo;
    		lo = lenOfB - 1 - hi;
    		hi = lenOfB - 1 - temp;
    	}
    	
    	lo++;
    	
		while (lo < hi) {
			int mid = lo + ((hi - lo) >>> 1);

			if (key <= array[base + mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return hi;
	}

	private void mergeLo(int start1, int length1, int start2, int length2) {
		// RUN A 를 담을 임시 복사 배열
		int[] temp = new int[length1];
		System.arraycopy(array, start1, temp, 0, length1); // RUN A를 temp 배열에 복사

		int insertIdx = start1;		// 재배치 되는 위치
		int runBIdx = start2;		// RUN B의 탐색 위치
		int tempIdx = 0;			// 복사한 RUN A의 탐색 위치

		int leftRemain = length1; 		// 배치해야 할 RUN A의 원소 개수
		int rightRemain = length2; 		// 배치해야 할 RUN B의 원소 개수

		// 두 원소 중 먼저 소진 될 때 까지 반복
		while (leftRemain != 0 && rightRemain != 0) {

			// RUN B < RUN A 라면 RUN B 원소 삽입
			if (array[runBIdx] < temp[tempIdx]) {
				array[insertIdx++] = array[runBIdx++];
				rightRemain--;
			} else {
				array[insertIdx++] = temp[tempIdx++];
				leftRemain--;
			}
		}

		// 왼쪽 부분 리스트가 남아있을 경우
		if (leftRemain != 0) {
			System.arraycopy(temp, tempIdx, array, insertIdx, leftRemain);
		} 
		else {	// 오른 쪽 부분 리스트가 남아있을 경우
			System.arraycopy(array, runBIdx, array, insertIdx, rightRemain);
		}

	}
    
	private void mergeHi(int start1, int length1, int start2, int length2) {
		// RUN B 를 담을 임시 복사 배열
		int[] temp = new int[length2];
		System.arraycopy(array, start2, temp, 0, length2);

		int insertIdx = start2 + length2 - 1;	// 재배치되는 위치 
		int runAIdx = start1 + length1 - 1;		// run A의 탐색 위치
		int tempIdx = length2 - 1;				// 복사한 run B의 탐색 위치

		int leftRemain = length1; 				// 배치해야 할 RUN A의 원소 개수
		int rightRemain = length2;				// 배치해야 할 RUN B의 원소 개수

		while (leftRemain != 0 && rightRemain != 0) {

			// RUN A' > RUN B' 라면 RUN A' 원소 삽입 (내림차순이기 때문)
			if (array[runAIdx] > temp[tempIdx]) {
				array[insertIdx--] = array[runAIdx--];
				leftRemain--;
			} else {
				array[insertIdx--] = temp[tempIdx--];
				rightRemain--;
			}
		}

		// 오른쪽 부분 리스트가 남아있을 경우
		if (rightRemain != 0) {
			System.arraycopy(temp, 0, array, start1, rightRemain);
		} else {
			System.arraycopy(array, start1, array, start1, leftRemain);
		}

	}	    	
}	// IntMergeStack class
