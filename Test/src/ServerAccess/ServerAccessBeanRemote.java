/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerAccess;

import EntitiesModels.Comment;
import EntitiesModels.Filters.GroupSelector;
import EntitiesModels.Filters.TestSelector;
import EntitiesModels.GroupEntity;
import EntitiesModels.Notifications.Notification;
import EntitiesModels.QuestionEntity;
import EntitiesModels.TestDescription;
import EntitiesModels.TestEntity;
import EntitiesModels.UserEntity;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 * Zdalny interfejs ziarna EJB zapewniającego dostęp klienta do warstwy logiki
 * biznesowej aplikacji.
 *
 * @author Krzysztof
 */
@Remote
public interface ServerAccessBeanRemote {

    /**
     * Operacja logowania do systemu.
     *
     * @param login Login użytkownika.
     * @param password Hasło użytkownika.
     * @return True, jeśli logowanie się powiodło. False oznacza błędne
     * parametry logowania.
     * @throws IllegalStateException Rzucany, jeśli sesja jest już
     * uwierzytelniona i nie nastąpiło wylogowanie.
     */
    Boolean Login(String login, String password) throws IllegalStateException;

    /**
     * Wylogowanie z systemu.
     *
     * @throws IllegalStateException Rzucany w przypadku próby wylogowania bez
     * uprzedniego zalogowania.
     */
    void Logout() throws IllegalStateException;

    /**
     * Pobiera obiekt encji użytkownika.
     *
     * @param login Login użytkownika.
     * @return Obiekt encji użytkownika.
     * @throws IllegalAccessException W przypadku braku uprawnień.
     */
    UserEntity getUserEntity(String login) throws IllegalAccessException;

    /**
     * Uaktualnia profil użytkownika.
     *
     * @param userEntity Nowy obiekt encji użytkownika.
     * @throws IllegalAccessException W przypadku braku uprawnień.
     */
    void updateUserEntity(UserEntity userEntity) throws IllegalAccessException;

    /**
     * Rejestruje nowego użytkownika.
     *
     * @param login Login
     * @param password Hasło
     * @param firstName Imię
     * @param lastName Nazwisko
     * @param eMail Adres e-mail
     * @return True, jeśli rejestracja się powiodła. False np. w przypadku
     * zajętej nazwy użytkownika.
     * @throws IllegalStateException Rzucany, jeśli klient jest zalogowany.
     */
    Boolean registerUser(String login, String password, String firstName, String lastName, String eMail) throws IllegalStateException;

    /**
     * Pobiera obiekt encji grupy.
     *
     * @param name Nazwa grupy.
     * @return Obiekt encji grupy
     * @throws IllegalAccessException W przypadku braku uprawnień.
     */
    GroupEntity getGroupEntity(String name) throws IllegalAccessException;

    /**
     * Uaktualnia encję grupy.
     *
     * @param groupEntity Obiekt encji grupy.
     * @throws IllegalAccessException W przypadku braku uprawnień.
     */
    void updateGroupEntity(GroupEntity groupEntity) throws IllegalAccessException;

    /**
     * Tworzy grupę.
     *
     * @param name Nazwa grupy.
     * @param description Opcjonalny opis.
     * @return True, jeśli udało się utworzyć grupę.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    Boolean createGroup(String name, String description) throws IllegalAccessException;

    /**
     * Dodaje użytkownika do grupy.
     *
     * @param groupName Nazwa grupy.
     * @param userLogin Login użytkownika.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawniń.
     */
    void addUserToGroup(String groupName, String userLogin) throws IllegalAccessException;

    /**
     * Usuwa użytkownika z grupy.
     *
     * @param groupName Nazwa grupy.
     * @param userLogin Login użytkownika.
     * @return True, jeśli uperacja się powiodła.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    Boolean removeUserFromGroup(String groupName, String userLogin) throws IllegalAccessException;

    /**
     * Pobiera obiekty encji użytkowników z grupy.
     *
     * @param groupName Nazwa grupy.
     * @return Lista użytkowników należących do grupy.
     * @throws IllegalAccessException Rzucany w przypakdu braku uprawnień.
     */
    List<UserEntity> getUsersFromGroup(String groupName) throws IllegalAccessException;

    /**
     * Pobiera opisy testów z grupy.
     *
     * @param groupName Nazwa grupy.
     * @return Lista opisów testów w grupie.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    List<TestDescription> getTestsFromGroup(String groupName) throws IllegalAccessException;

    /**
     * Tworzy nowy test.
     *
     * @param name Nazwa testu.
     * @param groupName Nazwa grupy.
     * @param category Nazwa kategorii.
     * @return Utworzony obiekt encji. Null w przypadku niepowodzenia.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    TestEntity createTest(String name, String groupName, String category) throws IllegalAccessException;

    /**
     * Uaktualnia test.
     *
     * @param testEntity Obiekt encji testu.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    void updateTestEntity(TestEntity testEntity) throws IllegalAccessException;

    /**
     * Usuwa test.
     *
     * @param testID Identyfikator testu.
     * @return True, jeśli operacja się powiodła.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    Boolean removeTest(long testID) throws IllegalAccessException;

    /**
     * Pobiera obiekt encji testu.
     *
     * @param testID Identyfikator testu.
     * @return Obiekt encji testu.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    TestEntity getTestEntity(long testID) throws IllegalAccessException;

    /**
     * Pobiera ocenę testu.
     *
     * @param testID Identyfikator testu.
     * @return Ocena testu.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    int getTestRating(long testID) throws IllegalAccessException;

    /**
     * Pobiera datę ostatniej modyfikacji testu.
     *
     * @param testID Identyfikator testu.
     * @return Data modyfikacji testu.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    Date getTestModificationDate(long testID) throws IllegalAccessException;

    /**
     * Zwraca listę komentarzy zamieszczonych pod testem.
     *
     * @param testID Identyfikator testu.
     * @return Lista komentarzy.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    List<Comment> getTestComments(long testID) throws IllegalAccessException;

    /**
     * Dodaje komentarz pod testem.
     *
     * @param testID Identyfikator testu.
     * @param content Treść komentarza.
     * @param rating Ocena testu.
     * @return Obiekt encji komentarza.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    Comment addComment(long testID, String content, int rating) throws IllegalAccessException;

    /**
     * Tworzy zgłoszenie błędu w pytaniu.
     *
     * @param testID Identyfikator testu.
     * @param indexInTest Indeks pytania w teście.
     * @param problemDesciption Opis problemu.
     * @param proposedSolution Propozycja rozwiązania.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    void reportQuestionError(long testID, int indexInTest, String problemDesciption, String proposedSolution) throws IllegalAccessException;

    /**
     * Dodaje propozycje pytania.
     *
     * @param testID Identyfikator testu.
     * @param question Obiekt reprezentujący pytanie.
     * @throws IllegalAccessException Rzucany w przypakdu braku uprawnień.
     */
    void addProposedQuestion(long testID, QuestionEntity question) throws IllegalAccessException;

    /**
     * Tworzy żądanie dołączenia do grupy.
     *
     * @param userLogin Login użytkownika, który chce dołączyć do grupy.
     * @param groupName Nazwa grupy.
     * @return True, jeśli udało się zapisać żądanie.
     * @throws IllegalAccessException Rzucany w przypakdu braku uprawnień.
     */
    Boolean requestJoiningGroup(String userLogin, String groupName) throws IllegalAccessException;

    /**
     * Pobiera komentarz na podstawie identyfikatora.
     *
     * @param commentID Identyfikator komentarza.
     * @return Obiekt encji komentarza.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    Comment getComment(long commentID) throws IllegalAccessException;

    /**
     * Pobiera powiadomienia dotyczące zalogowanego użytkownika.
     *
     * @return Lista powiadomień.
     * @throws IllegalAccessException Rzucany w przyapdku braku uprawenień.
     */
    List<Notification> getNotifications() throws IllegalAccessException;

    /**
     * Wyszukuje grupy.
     *
     * @param groupSelector Obiekt selekcjonujący grupy.
     * @return Lista grup pasujących do podanych kryteriów.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    List<GroupEntity> findGroups(GroupSelector groupSelector) throws IllegalAccessException;

    /**
     * Wyszukuje testy.
     *
     * @param testSelector Obiekt selekcjonujący testy.
     * @return Lista testów pasujących do podanych kryteriów.
     * @throws IllegalAccessException Rzucany w przypadku braku uprawnień.
     */
    List<TestDescription> findTests(TestSelector testSelector) throws IllegalAccessException;

}
