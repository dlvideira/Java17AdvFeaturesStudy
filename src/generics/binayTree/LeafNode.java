package generics.binayTree;
//TThis class is a Generic Type, defined by using <T>
//It is a placeholder for a concrete type
//It will be later filled when we use itt (like new LeafNode<Integer>(3)), i is called Instantiate Generic Type
//The result (LeafNode<Integer>) is called a Paramettterized Type (cannot use primitives like int)
public class LeafNode<T> implements TreeNode<T> {

    private final T value;

    public LeafNode(T value) {
        this.value = value;
    }

    //Normal method that return a Type
    @Override
    public T getValue() {
        return value;
    }

    //Normal method that return a TreeNode of T
    @Override
    public TreeNode<T> getLeft() {
        return null;
    }

    @Override
    public TreeNode<T> getRight() {
        return null;
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                '}';
    }
}
