package mears.trace.stats_application.sub_methods;

import java.util.ArrayList;
import java.util.List;

import mears.trace.stats_application.models.Favorite;

public class UserMethods {
	public static List<Integer> returnFavoriteIds(List<Favorite> fList){
		List<Integer> intList = new ArrayList<Integer>();
		if(fList.isEmpty()) {
			return new ArrayList<Integer>();
		}
		for(Favorite f: fList) {
			intList.add(f.getFighterId());
		}
		return intList;
	}
}
