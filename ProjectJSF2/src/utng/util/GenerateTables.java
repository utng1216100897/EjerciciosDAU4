package utng.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenerateTables {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("testdb");
	}
}
