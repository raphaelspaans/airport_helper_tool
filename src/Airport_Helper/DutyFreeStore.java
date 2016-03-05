package Airport_Helper;

public class DutyFreeStore {

	public String location;
	public String shortcut;
	public String name;
	public int discount;

	public DutyFreeStore(String locationStore, String shortcutStore, String nameStore, int discountStore)
	{
        location = locationStore;
        shortcut = shortcutStore;
		name = nameStore;
		discount = discountStore;
	}
	
	public static int discountDutyFreeStore()
	{
		int discount = 0;
		int randomDiscount = (int) (Math.random() * 100 + 1);
		if (randomDiscount > 90)
		{
			discount = 50;
		}
		else if (randomDiscount > 70)
		{
			discount = 30;
		}
		else if (randomDiscount > 50)
		{
			discount = 20;
		}
		else if (randomDiscount > 30)
		{
			discount = 10;
		}

		return discount;
	}
	
}
