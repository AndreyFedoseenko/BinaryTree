/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author АНДРЕЙ
 */
public class BinaryTr {

    int znachenie;
    BinaryTr LeftTree;
    BinaryTr RightTree;

    BinaryTr(int znachenie) {
        this.znachenie = znachenie;
        LeftTree = null;
        RightTree = null;
    }

    void Add(int NewElement) {
        BinaryTr obhod = this;
        if (obhod.znachenie > NewElement) {
            if (LeftTree == null) {
                BinaryTr Curr = new BinaryTr(NewElement);
                this.LeftTree = Curr;
            } else {
                obhod = obhod.LeftTree;
                obhod.Add(NewElement);
            }
        } else {
            if (RightTree == null) {
                BinaryTr Curr = new BinaryTr(NewElement);
                this.RightTree = Curr;
            } else {
                obhod = obhod.RightTree;
                obhod.Add(NewElement);
            }
        }
    }

    boolean Exists(int Element) {
        BinaryTr obhod = this;
        boolean tmp = false;
        //ArrayList<Boolean> tmp=new ArrayList<Boolean>();
        if (obhod.znachenie == Element) {
            //tmp.add(Boolean.TRUE);
            tmp = true;
            //return true;
        } else {
            while ((obhod.LeftTree != null) || (obhod.RightTree != null)) {
                if (obhod.znachenie == Element) {
                    tmp = true;
                    break;
                } else if (obhod.znachenie > Element) {
                    if (obhod.LeftTree != null) {
                        obhod = obhod.LeftTree;
                    } else {
                        break;
                    }
                } else {
                    if (obhod.RightTree != null) {
                        obhod = obhod.RightTree;
                    } else {
                        break;
                    }
                }
            }
        }
        if (tmp) {
            return true;
        } else {
            return false;
        }
    }

    BinaryTr Zamena(BinaryTr Curr) {
        BinaryTr Cu = this;
        if (Cu.LeftTree.znachenie != Curr.znachenie) {
            Cu.LeftTree = Cu.LeftTree.Zamena(Curr);
        } else {
            Cu.LeftTree = Curr.RightTree;
        }
        return Cu;
    }

    BinaryTr Rem(int Element) {
        if ((this.LeftTree.znachenie == Element) || (this.RightTree.znachenie == Element)) {
            if (this.LeftTree.znachenie == Element) {
                if ((this.LeftTree.LeftTree == null) && (this.LeftTree.RightTree == null)) {
                    this.LeftTree = null;
                } else if (this.LeftTree.LeftTree == null) {
                    this.LeftTree = this.LeftTree.RightTree;
                } else if (this.LeftTree.RightTree == null) {
                    this.LeftTree = this.LeftTree.LeftTree;
                } else {
                    BinaryTr Curr = this.LeftTree.RightTree;
                    BinaryTr Curr2 = this.LeftTree.RightTree;
                    if (Curr.LeftTree == null) {
                        this.LeftTree = Curr;
                    } else {
                        while (Curr.LeftTree != null) {
                            Curr = Curr.LeftTree;
                        }
                        Curr.RightTree = Curr2.Zamena(Curr);
                        Curr.LeftTree = this.LeftTree.LeftTree;
                        this.LeftTree = Curr;
                    }
                }
            }
            if (this.RightTree.znachenie == Element) {
                if ((this.RightTree.LeftTree == null) && (this.RightTree.RightTree == null)) {
                    this.RightTree = null;
                } else if (this.RightTree.LeftTree == null) {
                    this.RightTree = this.RightTree.RightTree;
                } else if (this.RightTree.RightTree == null) {
                    this.RightTree = this.RightTree.LeftTree;
                } else {
                    BinaryTr Curr = this.RightTree.RightTree;
                    BinaryTr Curr2 = this.RightTree.RightTree;
                    if (Curr.LeftTree == null) {
                        this.LeftTree = Curr;
                    } else {
                        while (Curr.LeftTree != null) {
                            Curr = Curr.LeftTree;
                        }
                        Curr.RightTree = Curr2.Zamena(Curr);
                        Curr.LeftTree = this.RightTree.LeftTree;
                        this.RightTree = Curr;
                    }
                }
            }
        } else {
            if (this.znachenie > Element) {
                this.LeftTree.Rem(Element);
            } else if (this.znachenie < Element) {
                this.RightTree.Rem(Element);
            } else {
                System.out.println("We cannot delete root");
            }
        }
        return this;
    }

    boolean Remove(int Element) {
        if (this.Exists(Element)) {
            this.Rem(Element);
            return true;
        } else {
            return false;
        }
    }

    void PrintByDepht() {
        System.out.print(this.znachenie + ", ");
        if (this.LeftTree != null) {
            this.LeftTree.PrintByDepht();
        }
        if (this.RightTree != null) {
            this.RightTree.PrintByDepht();
        }
    }

    public void printByWidth() {
        ArrayBlockingQueue<BinaryTr> ochered = new ArrayBlockingQueue<BinaryTr>(100);
        BinaryTr current = this;
        ochered.add(current);
        while (!ochered.isEmpty()) {
            current = ochered.poll();
            System.out.print(current.znachenie + " ");
            if (current.LeftTree != null) {
                ochered.add(current.LeftTree);
            }
            if (current.RightTree != null) {
                ochered.add(current.RightTree);
            }
        }
    }
}
