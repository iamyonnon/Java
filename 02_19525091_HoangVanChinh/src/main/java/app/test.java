package app;

import hibernateConfig.HibernateConfig;

public class test {
public static void main(String[] args) {
	HibernateConfig.getInstance().getSessionFactory();
}
}
