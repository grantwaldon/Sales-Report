public class CalculateBonus {
	
	/**
	 * Calculates the bonus for each store
	 * 
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateBonus(double[][] data, 
			double high, double low, double other)
	{
		double[] bonus = new double[data.length];
		
		for(int row = 0;row < data.length;row++)
		{
			double bonusAmount = 0.0;
			
			for(int col = 0;col < data[row].length;col++)
			{
				if(data[row][col] <= 0)
				{
					continue;
				}
				else if(row == FileUtility.getHighestInColumnIndex(data, col))
				{
					bonusAmount += high;
				}
				else if(row == FileUtility.getLowestInColumnIndex(data, col))
				{
					bonusAmount += low;
				}
				else
				{
					bonusAmount += other;
				}
			}
			
			bonus[row] = bonusAmount;
		}
		
		return bonus;
	}
	
	/**
	 * Calculates the total bonus amount
	 * 
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @return the total of all holiday bonuses
	 */
	public static double calculateTotalBonus(double[][] data, 
			double high, double low, double other)
	{
		double total = 0.0;
		
		double[] bonuses = calculateBonus(data, high, low, other);
		
		for(int i = 0;i < bonuses.length;i++)
		{
			total += bonuses[i];
		}
		
		return total;
	}
}