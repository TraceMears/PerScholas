package mears.trace.stats_application.repositories;

public interface UserRepository {
	Boolean login();
	Boolean createUser();
	Boolean deleteUser();
	Boolean updatePassword();
	Boolean addToFavorites();
}
