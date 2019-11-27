
package Classes;

/**
 *
 * @author usuario
 */

public class User {

    private int id; 
    private String name;
    private String license;

    private User next;

    /**
     * User constructor
     *
     * @param id user id
     * @param name user name
     * @param license type user license.
     */
    public User(int id, String name, String license) {
        this.id = id;
        this.name = name;
        this.license = license;
    }

    /**
     * get user id
     *
     * @return Int with user id. Ej: 2019076574.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Get next user in list.
     *
     * @return next user in list;
     */
    public User Next() {
        return this.next;
    }

    /**
     * set next user in list.
     *
     * @param next next user in list;
     */
    public void Next(User next) {
        this.next = next;
    }

    /**
     * get user name.
     *
     * @return user name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * get type user license.
     *
     * @return type license.
     */
    public String getLicense() {
        return this.license;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param license
     */
    public void setLicense(String license) {
        this.license = license;
    }

}
