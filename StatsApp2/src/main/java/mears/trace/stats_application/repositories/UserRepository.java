package mears.trace.stats_application.repositories;

import java.util.List;

import mears.trace.stats_application.models.Favorite;
import mears.trace.stats_application.models.User;

public interface UserRepository {
	User login(String user, String pass);
	User getUser(Integer uId);
	User adminLogin(String user, String pass);
	Integer createUser(User u);
	Integer deleteUser(Integer uId);
	Boolean updatePassword(User u);
	Boolean addToFavorites(User u, Integer fId);
	Boolean removeFavorite(User u, Integer fId);
	Boolean updateFavoriteNumber(Favorite f);
	List<Favorite> getFavoriteList(User u);
	Integer retrieveFavoriteNum(User u, Integer fId);
	List<User> getAllUsers();
} 
