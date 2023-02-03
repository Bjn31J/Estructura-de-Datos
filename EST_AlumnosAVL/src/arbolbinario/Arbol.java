package arbolbinario;

public class Arbol<T extends Comparable> {

    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void insertar(Comparable elemento) {
        raiz = insertar(raiz, elemento);
    }

    private Object elementosNodo(Nodo arbol) {
        if (arbol == null) {
            return null;
        } else {
            return arbol.getElemento();
        }
    }

    public static int factorEquilibrio(Nodo arbol) {
        if (arbol == null) {
            return -1;
        } else {
            return arbol.getFactorEquilibrio();
        }
    }

    private static int maxFB(int alturaIzquierdo, int alturaDerecho) {
        if (alturaIzquierdo > alturaDerecho) {
            return alturaIzquierdo;
        } else {
            return alturaDerecho;
        }
    }

    public Nodo insertar(Nodo arbol, Comparable elemento) {
        if (arbol == null) {
            arbol = new Nodo(elemento, null, null);
        } else if (elemento.compareTo(arbol.getElemento()) < 0) {
            arbol.setIzq(insertar(arbol.getIzq(), elemento));
            if (factorEquilibrio(arbol.getIzq()) - factorEquilibrio(arbol.getDer()) == 2) {
                if (elemento.compareTo(arbol.getIzq().getElemento()) < 0) {
                    arbol = RotacionSimpleIzq(arbol);
                } else {
                    arbol = RotacionDobleIzq_Der(arbol);
                }
            }
        } else if (elemento.compareTo(arbol.getElemento()) > 0) {
            arbol.setDer(insertar(arbol.getDer(), elemento));
            if (factorEquilibrio(arbol.getDer()) - factorEquilibrio(arbol.getIzq()) == 2) {
                if (elemento.compareTo(arbol.getDer().getElemento()) > 0) {
                    arbol = RotacionSimpleDer(arbol);
                } else {
                    arbol = RotacionDobleDer_Izq(arbol);
                }
            }
        }
        arbol.setFactorEquilibrio(maxFB(factorEquilibrio(arbol.getIzq()),
                factorEquilibrio(arbol.getDer())) + 1);
        return arbol;
    }

    private static Nodo RotacionSimpleIzq(Nodo arbol) {
        Nodo subArbol = arbol.getIzq();
        arbol.setIzq(subArbol.getDer());
        subArbol.setDer(arbol);
        arbol.setFactorEquilibrio(maxFB(factorEquilibrio(arbol.getIzq()),
                factorEquilibrio(arbol.getDer())) + 1);
        subArbol.setFactorEquilibrio(maxFB(factorEquilibrio(subArbol.getIzq()),
                arbol.getFactorEquilibrio()) + 1);
        return subArbol;
    }

    private static Nodo RotacionSimpleDer(Nodo subArbol) {
        Nodo arbol = subArbol.getDer();
        subArbol.setDer(arbol.getIzq());
        arbol.setIzq(subArbol);
        subArbol.setFactorEquilibrio(maxFB(factorEquilibrio(subArbol.getIzq()),
                factorEquilibrio(subArbol.getDer())) + 1);
        arbol.setFactorEquilibrio(maxFB(factorEquilibrio(arbol.getDer()),
                subArbol.getFactorEquilibrio()) + 1);
        return arbol;
    }

    private static Nodo RotacionDobleIzq_Der(Nodo arbol) {
        arbol.setIzq(RotacionSimpleDer(arbol.getIzq()));
        return RotacionSimpleIzq(arbol);
    }

    private static Nodo RotacionDobleDer_Izq(Nodo subArbol) {
        subArbol.setDer(RotacionSimpleIzq(subArbol.getDer()));
        return RotacionSimpleDer(subArbol);
    }

    public boolean removeNodo(Comparable elemento) {

        Nodo nodo = this.buscar(elemento);
        if (nodo != null) {
            /* Creamos variables para saber si tiene hijos izquierdo y derecho */
            boolean tieneNodoDerecha = nodo.getDer() != null ? true : false;
            boolean tieneNodoIzquierda = nodo.getIzq() != null ? true : false;

            if (!tieneNodoDerecha && !tieneNodoIzquierda) {
                return removeNodoCaso1(nodo);
            }

            /* Caso 2: Tiene un hijo y el otro no */
            if (tieneNodoDerecha && !tieneNodoIzquierda) {
                return removeNodoCaso2(nodo);
            }

            /* Caso 2: Tiene un hijo y el otro no */
            if (!tieneNodoDerecha && tieneNodoIzquierda) {
                return removeNodoCaso2(nodo);
            }

            /* Caso 3: Tiene ambos hijos */
            if (tieneNodoDerecha && tieneNodoIzquierda) {
                return removeNodoCaso3(nodo);
            }
        }
        return false;
    }

    private boolean removeNodoCaso1(Nodo nodo) {
        Nodo padre = this.saberPadre(nodo.getElemento());
        Nodo hijoIzquierdo = padre.getIzq();
        Nodo hijoDerecho = padre.getDer();
        // Si solo hay un nodo raíz y se acaba de encontrar
        if (nodo == raiz) {
            raiz = null;
            return true;
        }

        if (hijoIzquierdo == nodo) {
            padre.setIzq(null);
            return true;
        }

        if (hijoDerecho == nodo) {
            padre.setDer(null);
            return true;
        }
        return false;
    }

    private boolean removeNodoCaso2(Nodo nodo) {

        Nodo padre = this.saberPadre(nodo.getElemento());
        Nodo hijoIzquierdo = padre.getIzq();
        Nodo hijoDerecho = padre.getDer();

        Nodo hijoActual = nodo.getIzq() != null
                ? nodo.getIzq() : nodo.getDer();

        if (hijoIzquierdo == nodo) {
            padre.setIzq(hijoActual);

            nodo.setDer(null);
            nodo.setIzq(null);

            return true;
        }

        if (hijoDerecho == nodo) {
            padre.setDer(hijoActual);
            nodo.setDer(null);
            nodo.setIzq(null);

            return true;
        }

        return false;
    }

    private boolean removeNodoCaso3(Nodo nodo) {
        // Primero encuentre el nodo sucesor en orden del nodo:
        Nodo tmp = recorrerIzquierda(nodo);
        //saber padre
        Nodo parent = saberPadre(nodo.getElemento());
        // Ahora tmp es el nodo sucesor en orden
        // Si se elimina el nodo raíz
        if (nodo == raiz) {
            raiz = tmp;
        } // No es el nodo raíz, entonces juzgue si el nodo es el nodo hijo izquierdo de su nodo padre o el nodo hijo derecho de su nodo padre
        else if (parent.getIzq() != null && parent.getIzq() == nodo) {
            // Es el nodo hijo izquierdo
            parent.setIzq(tmp);
        } else {
            // Es el nodo hijo correcto
            parent.setDer(tmp);
        }
        // Nota: una vez que se completa el reemplazo, debe consultar los datos del nodo izquierdo del nodo anterior
        // Los datos del nodo correcto se han citado de nuevo en el método siguiente en el pedido, no es necesario escribir aquí
        tmp.setIzq(nodo.getIzq());
        return true;
    }

    private Nodo recorrerIzquierda(Nodo deleteNode) {
        Nodo replaceNode = deleteNode;
        Nodo replaceParentNode = deleteNode;
        Nodo current = deleteNode.getDer();

        while (current != null) {
            replaceParentNode = replaceNode;
            replaceNode = current;
            current = current.getIzq();
        }
        // Determine si el nodo sucesor en orden es el nodo hijo derecho de deleteNode (esta situación se debe a que el nodo hijo derecho del nodo delete no tiene un nodo hijo izquierdo)
        if (replaceNode != deleteNode.getDer()) {
            // El nodo hijo derecho del nodo sucesor en el orden medio se convierte en el nodo hijo izquierdo del nodo padre del nodo sucesor en el orden medio
            replaceParentNode.setIzq(replaceNode.getDer());
            // Al mismo tiempo, el nodo hijo derecho del nodo eliminado se convierte en el nodo derecho del nodo sucesor en orden
            replaceParentNode.setDer(deleteNode.getDer());
        }
        return replaceNode;
    }

    private Nodo saberPadre(Comparable nodo) {
        Nodo aux = raiz;
        Nodo aux2 = aux;
        while (aux != null) {
            if (nodo.compareTo(aux.getElemento()) < 0) {
                aux2 = aux;
                aux = aux.getIzq();
            } else if (nodo.compareTo(aux.getElemento()) > 0) {
                aux2 = aux;
                aux = aux.getDer();
            } else if (nodo.compareTo(aux.getElemento()) == 0) {
                return aux2;
            }
        }
        return null;
    }

    public Nodo buscar(Comparable nodo) {
        Nodo aux = raiz;
        Nodo aux2 = aux;
        while (aux != null) {
            if (nodo.compareTo(aux.getElemento()) < 0) {
                aux2 = aux;
                aux = aux.getIzq();
            } else if (nodo.compareTo(aux.getElemento()) > 0) {
                aux2 = aux;
                aux = aux.getDer();
            } else if (nodo.compareTo(aux.getElemento()) == 0) {
                return aux;
            }
        }
        return null;
    }
   
    
    private Nodo equilibrar(Nodo nodo, Comparable dato) {
        if (nodo == null) {
            return null;
        }
        if (dato.compareTo(nodo.getElemento()) < 0) {
            equilibrar(nodo.getIzq(), dato);
        } else if (dato.compareTo(nodo.getElemento()) > 0) {
            equilibrar(nodo.getDer(), dato);
        } else if (dato.compareTo(nodo.getElemento()) == 0) {
            return nodo;
        }

        return null;
    }

    private void preorden(Nodo n) {
        if (n != null) {
            System.out.print(n.getElemento() + ",");
            preorden(n.getIzq());
            preorden(n.getDer());
        }
    }

    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.getIzq());
            System.out.print(n.getElemento() + ",");
            inorden(n.getDer());
        }
    }

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getIzq());
            postorden(n.getDer());
            System.out.print(n.getElemento() + ",");
        }
    }

    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
    }
}
