package generics.binayTree;

public class GenericExample {

    public static void main(String[] args) {
        //We can specify the type of the value by putttin Integer inside <> OR
        var three = new LeafNode<Integer>(3);

        //We can just leave the <> Diamond Operator to compiler define the type by Type Inference
        var five = new LeafNode<>(5);

        var tree = new InnerNode<>(new LeafNode<>(2), new InnerNode<>(three, five));

        System.out.println(tree);
    }
}
