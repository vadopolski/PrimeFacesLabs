package com.vopolski.car;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "treeDNDView")
@ViewScoped
public class DragDropView implements Serializable {
    private TreeNode root1;

    private TreeNode selectedNode1;

    private String id = "";

    private String year = "";

    private String color = "";

    private String brand = "";

    private String model = "";

    private static int max;

    public void buttonAction(ActionEvent actionEvent) {
        brand = "Lamborghini Diablo GT";
    }

    public static int getMax() {
        return max;
    }

    public void setRoot1(TreeNode root1) {
        this.root1 = root1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @PostConstruct
    public void init() {
        root1 = new DefaultTreeNode(new Car("Transport", "", "", "", ""), null);

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

        maxLengthOfBrandName(root1);

    }

    public static void maxLengthOfBrandName(TreeNode root1) {
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
                maxLengthOfBrandName(node);
            }
        }
    }

    public TreeNode getRoot1() {
        return root1;
    }

    public TreeNode getSelectedNode1() {
        return selectedNode1;
    }

    public void setSelectedNode1(TreeNode selectedNode1) {
        this.selectedNode1 = selectedNode1;
    }

    public void onDragDrop(TreeDragDropEvent event) {
        TreeNode dragNode = event.getDragNode();
        int dropIndex = event.getDropIndex();
    }

    public void onNodeSelect(NodeSelectEvent event) {
        Car data = (Car)event.getTreeNode().getData();

        this.id = data.getId();
        this.brand = data.getBrand();
        this.color = data.getColor();
        this.year = data.getYear();
        this.model = data.getModel();

        RequestContext context = RequestContext.getCurrentInstance();
        TreeNode selectedNode = (TreeNode)event.getTreeNode();
        if (selectedNode != null) {
            if (selectedNode.getChildCount() > 0) {
                if (selectedNode.isExpanded()) {
                    selectedNode.setExpanded(false);
                    context.update("form1:tree1");
                }
                else {
                    selectedNode.setExpanded(true);
                    context.update("form1:tree1");
                }
            }
        }
    }

}