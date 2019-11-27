

package Logic;
import Classes.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class HashMethods {
    
    public static HashMethods instance = null;    

    public static HashMethods getInstance() {
        if (instance == null) {
            instance = new HashMethods();
        }
        return instance;
    }

    private final int size = 19;

    public final User table[];

   
    public HashMethods() {
        this.table = new User[size];
    }

    
    private int hash(int number) {
        return (number & 0xfffffff) % this.size;
    }

   
    public boolean put(User user){
        int key = this.hash(user.getId());

        User aux = this.table[key];

        if (aux == null) {
            this.table[key] = user;
            return true;
        }
            for (; aux != null; aux = aux.Next()) {
                if (aux.getId() == user.getId()) {                   
                    JOptionPane.showMessageDialog(null, "La cédula ya existe");
                    return false;
                }
                if (aux.Next() == null) {
                    aux.Next(user);
                    break;
                }
            }        
        return true;
    }  
    
    
  
    public User get(int number) {
        int key = this.hash(number);
        if (this.table[key] == null) {
            return null;
        }
        User aux = this.table[key];
        for (; aux != null; aux = aux.Next()) {
            if (aux.getId() == number) {
                break;
            }
        }
        return aux;
    }

   public String delete(int number) {
        int key = this.hash(number);

        if (this.table[key] == null) {
            return null;
        }

        User aux = this.table[key];

        if (aux.Next() == null) {
            this.table[key] = null;
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            
        }

        int index = 0;
        while (aux != null) {

            aux = aux.Next();
            index++;
        }
        User arrayUsers[] = new User[index];

        aux = this.table[key];

        int n = 0;
        while (aux != null) {

            if (aux.getId() == number) {                
                JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            } else {
                arrayUsers[n] = aux;
                n++;
            }
            aux = aux.Next();

        }

        this.table[key] = null;

        for (int i = 0; i < index - 1; i++) {
            if (arrayUsers[i].getId() == number) {

            } else {
                User nUser = new User(arrayUsers[i].getId(), arrayUsers[i].getName(), arrayUsers[i].getLicense());
                put(nUser);
            }

        }

        JOptionPane.showMessageDialog(null, "Usuario no existe");
        return null;

    }

    public void editName(int number, String name) {
        int key = this.hash(number);
        if (this.table[key] == null) {
            JOptionPane.showMessageDialog(null, "El usuario no existe ");
            return;
        }
        User aux = this.table[key];
        for (; aux != null; aux = aux.Next()) {
            if (aux.getId() == number) {
                JOptionPane.showMessageDialog(null, "Nombre actualizado ");
                aux.setName(name);
                return;
            }
        }
    }
    
   public boolean editarLicense(int number, String licencia) {
        int key = this.hash(number);
        if (this.table[key] == null) {
            JOptionPane.showMessageDialog(null, "El usuario no existe ");
            return false;
        }
        User aux = this.table[key];
        for (; aux != null; aux = aux.Next()) {
            if (aux.getId() == number) {
                JOptionPane.showMessageDialog(null, "Licencia actualizada ");
                aux.setLicense(licencia);
                return true;
            }
        }
    return false;
    }
   
    public User searchUser(int number){
        int key = this.hash(number);
        if (this.table[key] == null) {
            JOptionPane.showMessageDialog(null, "El usuario no existe ");
            return null;
        }
        User aux = this.table[key];
        for (; aux != null; aux = aux.Next()) {
            if (aux.getId() == number) {
                return aux;             
            }
        }   
    return null;    
    }
    
     public boolean editId(int number, int id) {
        int key = this.hash(number);
        if (this.table[key] == null) {
            JOptionPane.showMessageDialog(null, "El usuario no existe ");
            return false;
        }
        User aux = this.table[key];
        for (; aux != null; aux = aux.Next()){
            if (aux.getId() == number) {
                JOptionPane.showMessageDialog(null, "Cedula actualizada ");
                aux.setId(id);
                return true;
            }
        }return false;
    }
    
    public void getModel(DefaultTableModel model) {
        for (User table1 : this.table) {
            for (User aux = table1; aux != null; aux = aux.Next()) {
                Object[] row = new Object[3];
                row[0] = aux.getId();
                row[1] = aux.getName();
                row[2] = aux.getLicense();
                model.addRow(row);
            }
        }
    }

}
