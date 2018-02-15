package com.vopolski;

import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

public class TreeNodeSearch {

    private static List<Car> list = new ArrayList<Car>();

    private static int max;

    public static void main(String[] args) {
        System.out.println("Test");

        TreeNode root1 = new DefaultTreeNode(new Car("Transport", "", "", "", ""), null);

        TreeNode sedan = new DefaultTreeNode(new Car("001", "", "", "Sedan", ""), root1);
        TreeNode hatchback = new DefaultTreeNode(new Car("002", "", "", "HatchBack", ""), root1);
        TreeNode minivan = new DefaultTreeNode(new Car("003", "", "", "Minivan", ""), root1);

        TreeNode sedan1 = new DefaultTreeNode(new Car("004", "2017", "White", "Hyundai", "Elantra"), sedan);
        TreeNode sedan2 = new DefaultTreeNode(new Car("005", "All time", "Black", "Toyota", "Corolla"), sedan);
        TreeNode sedan3 = new DefaultTreeNode(new Car("008", "2015-2018", "Silver", "Ford", "Focus"), sedan);
        TreeNode sedan4 = new DefaultTreeNode(new Car("009", "2017", "White", "Kia Rio", "Focus"), sedan);
        TreeNode sedan5 = new DefaultTreeNode(new Car("010", "2018", "Black", "Volkswagen", "Jetta"), sedan);
        TreeNode sedan6 = new DefaultTreeNode(new Car("011", "All time", "White", "Toyota", "Camry"), sedan);
        TreeNode sedan7 = new DefaultTreeNode(new Car("012", "2011", "Blue", "Chevrolet", "Cruze"), sedan);
        TreeNode sedan8 = new DefaultTreeNode(new Car("013", "All time", "White", "Toyota", "Camry"), sedan);

        TreeNode hatchback1 = new DefaultTreeNode(new Car("006", "All time", "Yellow", "Ford", "Fiesta"), hatchback);
        TreeNode hatchback2 = new DefaultTreeNode(new Car("014", "2018", "Black", "VolksWagen", "Golf"), hatchback);

        TreeNode minivan1 = new DefaultTreeNode(new Car("007", "2011", "White", "GM", "Wuling sunshine"), minivan);

//        int max = maxBrandName(root1);

        treeNodeToList(root1);

        System.out.println(list.size());

    }

    public static void treeNodeToList(TreeNode root1) {
        List<TreeNode> children = root1.getChildren();

        if (children.size() == 0) {
            Car car = (Car)root1.getData();

            int brandLength = car.getBrand().length();
            if (brandLength > max) {
                max = brandLength;
            }
        }
        else {
            for (TreeNode node : children) {
                treeNodeToList(node);
            }
        }
    }

    private static int maxBrandName(TreeNode root1) {
        int max = 0;
        List<TreeNode> children = root1.getChildren();

        for (TreeNode node : children) {
            Car car = (Car)node;
            int brandLength = car.getBrand().length();
            if (brandLength > max) {
                max = brandLength;
            }
        }
        return max;
    }
}
