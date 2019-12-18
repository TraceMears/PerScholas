package mears.trace.stats_application.repositories;

import java.util.List;

import mears.trace.stats_application.models.Fighter;
import mears.trace.stats_application.models.User;;

public interface FighterRepository {
	List<Fighter> showFighters();
	Fighter retrieveFighter(Integer id);
	List<Fighter> getFavoriteFighters(List<Integer> list);
	
}
