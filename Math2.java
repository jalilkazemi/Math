
=======
>d>>>>>> 4cc48d3432e192e42ea7d492f6f4a12218cea8ef
public class MyMath {
	public static int choose(int n, int k) {
		if(n < k || k < 0)
			return 0;
		if(k == 1 || k == n - 1)
			return n;
		int result = 0;
		for(int i = k - 1; i < n; i++)
			result += choose(i, k - 1);
		return result;
	}

	public static int min(int a, int b) {
		return a < b ? a : b;
	}

	public static int[] sample(int nsubject, int ndraw) {
		int[] sample = new int[ndraw];
		if(ndraw * ndraw < nsubject * Math.log(nsubject) * 3) {
			int[] order = new int[ndraw];
			int rndIndex;
			int swap;
			for (int i = 0; i < ndraw; i++) {
				rndIndex = (int) Math.floor(Math.random() * (nsubject - i));
				sample[ndraw - i - 1] = rndIndex;
				order[i] = ndraw - i - 1;
				for (int j = i; j > 0; j--) {
					if(sample[order[j]] >= sample[order[j - 1]]) {
						sample[order[j]]++;
						swap = order[j]; order[j] = order[j - 1]; order[j - 1] = swap;
					} else {
						break;
					}
				}
			}
		} else {
			Double[] shuffle = new Double[nsubject];
			int[] order;
			for (int i = 0; i < nsubject; i++) {
				shuffle[i] = Math.random();
			}
			order = sort(shuffle);
			for (int i = 0; i < ndraw; i++) {
				sample[i] = order[i];
			}
		}
		return sample;
	}

	private static void mergeSort(double[] list, int[] order) {
		int n = list.length;
		if(n < 2)
			return;
		int[] side = new int[n];
		for (int width = 1; width < n; width *= 2)
			for (int i = 0; i < n; i += 2 * width) {
				int mid = min(i + width, n), end = min(i + 2 * width, n);
				int j0 = i, j1 = mid;
				for (int j = i; j < end; j++) {
					if(j0 < mid && (j1 >= end || list[order[j0]] < list[order[j1]])) {
						side[j] = order[j0];
						j0++;
					} else {
						side[j] = order[j1];
						j1++;
					}
				}
				for (int j = i; j < end; j++)
					order[j] = side[j];
			}
	}

	public static int[] sort(int[] list) {
		int n = list.length;
		int[] order = new int[n];
		for (int i = 0; i < n; i++) 
			order[i] = i;
		mergeSort(list, order);
		return order;
	}

	private static void mergeSort(int[] list, int[] order) {
		int n = list.length;
		if(n < 2)
			return;
		int[] side = new int[n];
		for (int width = 1; width < n; width *= 2)
			for (int i = 0; i < n; i += 2 * width) {
				int mid = min(i + width, n), end = min(i + 2 * width, n);
				int j0 = i, j1 = mid;
				for (int j = i; j < end; j++) {
					if(j0 < mid && (j1 >= end || list[order[j0]] < list[order[j1]])) {
						side[j] = order[j0];
						j0++;
					} else {
						side[j] = order[j1];
						j1++;
					}
				}
				for (int j = i; j < end; j++)
					order[j] = side[j];
			}
	}

	public static <T extends Comparable<? super T>> int[] sort(T[] list) {
		int n = list.length;
		int[] order = new int[n];
		for (int i = 0; i < n; i++) 
			order[i] = i;
		mergeSort(list, order);
		return order;
	}

	private static <T extends Comparable<? super T>> void mergeSort(T[] list, int[] order) {
		int n = list.length;
		if(n < 2)
			return;
		int[] side = new int[n];
		for (int width = 1; width < n; width *= 2)
			for (int i = 0; i < n; i += 2 * width) {
				int mid = min(i + width, n), end = min(i + 2 * width, n);
				int j0 = i, j1 = mid;
				for (int j = i; j < end; j++) {
					if(j0 < mid && (j1 >= end || list[order[j0]].compareTo(list[order[j1]]) < 0 )) {
						side[j] = order[j0];
						j0++;
					} else {
						side[j] = order[j1];
						j1++;
					}
				}
				for (int j = i; j < end; j++)
					order[j] = side[j];
			}
	}
}
