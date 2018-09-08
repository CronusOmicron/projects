package bin;

public class NetworkTools {
	public static double[] createArray(int size, double init_value)
	{
		if (size < 1) return null;

		double[] ar = new double[size];
		for(int i = 0; i < size; i++)
		{
			ar[i] = init_value;
		}
		return ar;
	}
	public static double[] createRandomArray(int size, double lower_bound, double upper_bound)
	{
		if(size < 1) return null;
		double[] ar = new double[size];
		for(int i = 0; i < size; i++)
		{
			ar[i] = randomValue(lower_bound, upper_bound);
		}
		return ar;
	}
	public static double[][] createRandomArray( int size_x, int size_y, double lower_bound, double upper_bound)
	{
		if(size_x < 1 || size_y < 1) return null;
		double[][] ar = new double[size_x][size_y];
		for(int x = 0; x < size_x; x++)
		{
			ar[x] = createRandomArray(size_y, lower_bound, upper_bound);
		}
		return ar;
	}
	public static double randomValue(double lower_bound, double upper_bound)
	{    
		//if(lower_bound > upper_bound) return null;
		return (Math.random() * (upper_bound - lower_bound) + lower_bound);
		
	}
	public static Integer[] randomValues(int lower_bound, int upper_bound, int amount)
	{
		lower_bound--;
		if(amount > (upper_bound - lower_bound)) return null;
		Integer[] values = new Integer[amount];
		
		for(int i = 0; i < amount; i++)
		{
			int n = (int)(Math.random() * (upper_bound-lower_bound + 1) + lower_bound);
			while(containsValue(values, n))
			{
				n = (int)(Math.random() * (upper_bound-lower_bound + 1) + lower_bound);
			}
			values[i] = n;
		}
		return values;
	}
	public static <T extends Comparable<T>> boolean containsValue(T[] ar, T value)
	{
		for(int i = 0; i < ar.length; i++)
		{
			if(ar[i] != null)
			{
				if(value.compareTo(ar[i]) == 0) return true;
			}
		}
		return false;
	}
	public static int indexOfHighestValue(double[] values)
	{
		int index = 0;
		for (int i = 1; i < values.length; i++)
		{
			if(values[i] > values[index]) index = i;
		}
		return index;
	}

}
