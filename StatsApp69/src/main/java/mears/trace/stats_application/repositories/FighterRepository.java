package mears.trace.stats_application.repositories;

import java.util.List;

import mears.trace.stats_application.models.Fighter;;

public interface FighterRepository {
	List<Fighter> showFighters();
	Fighter retreiveFighter(Integer id);
}
