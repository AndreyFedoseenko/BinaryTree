/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author АНДРЕЙ
 */
public class BinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTr Derevo = new BinaryTr(12);
        Derevo.Add(105);
        Derevo.Add(79);
        Derevo.Add(10);
        Derevo.Add(3);
        Derevo.Add(4);
        Derevo.Add(112);
        Derevo.Add(134);
        Derevo.Add(76);
        Derevo.Add(109);
        Derevo.Add(107);
        Derevo.Add(108);
        Derevo.Add(110);
        //System.out.println(Derevo.Exists(12));
        Derevo.printByWidth();
    }
}
