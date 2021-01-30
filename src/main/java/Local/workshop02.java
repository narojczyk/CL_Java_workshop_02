package Local;

import Dao.UserDao;

public class workshop02 {
    public static void main(String[] args){

        // DODAWANIE REKORDOW DO BAZY DANYCH
        int maxRecordsToFeed = 0;
        User userFeed = new User();
        UserDao uDAO = new UserDao("workshop2");
        System.out.printf("Populating database with %d records\n", maxRecordsToFeed);
        for(int i=0; i<maxRecordsToFeed; i++){
            userFeed.setUsrName( ("name_" + i) );
            userFeed.setUsrEmail(userFeed.getUsrName()+"@kiss.my.ass.com");
            userFeed.setUsrPasswd( ("Sup3r s3cr3t P@ssuuord_"+i) );
            uDAO.create(userFeed);
        }

        // CZYTANIE REKORDU W BAZIE DANYCH
        int idToRead = 19;
        System.out.printf("Reading record with id=%d\t", idToRead);
        User userRead = uDAO.read(idToRead);
        if(userRead != null) {
            System.out.printf("\n\t%s\n", userRead.toString());
        }else{
            System.out.printf("Brak rekordu o id=%d\n", idToRead);
        }

        // MODYFIKACJA REKORDU W BAZIE DANYCH
        int idToModify = 20;
        System.out.printf("Modifying record with id=%d\t", idToModify);
        User userModify = uDAO.read(idToModify);
        if(userModify != null) {
            userModify.setUsrName("JoeMonster");
            userModify.setUsrEmail(userModify.getUsrName() + "@kiss.my.ass.com");
            userModify.setUsrPasswd(("JoeMonster Dumb password"));
        }
        System.out.printf("(%d records modified)\n", uDAO.update(userModify));

        // USUWANIE REKORDU Z BAZY DANYCH
        int idToDelete = 20;
        System.out.printf("Deleting record with id=%d\t", idToDelete);
        System.out.printf("(%d records deleted)\n", uDAO.delete(idToDelete));

        // ZCZYTANIE WSZYSTKICH REKORDÓW Z BAZY DANYCH
        User[] listOfAllUsers = uDAO.readAll();
        System.out.printf("Czytanie wszystkich rekordów z bazy\t(pobrano %d rekordow)\n",listOfAllUsers.length);
        for(int i=0; i<listOfAllUsers.length; i++){
            System.out.println(listOfAllUsers[i].toString());
        }

        // CZYSZCZENIE LOKALNYCH OBIEKTOW GDY NIE SA JUZ POTRZEBNE
        System.out.print("Czytanie wszystkich lokalnych obiektów zawierających dane z bazy\n");
        for(int i=0; i<listOfAllUsers.length; i++){
            if(listOfAllUsers[i] != null ){
                listOfAllUsers[i].clearObjectData();
            }
        }
        if(userModify != null) {
             userModify.clearObjectData();
        }

        userFeed.clearObjectData();

        if(userRead != null){
             userRead.clearObjectData();
        }


    }

}
