package com.vopolski.products;

import com.vopolski.car.Car;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "productView")
@ViewScoped
public class ProductView implements Serializable {
    private TreeNode root1;

    private TreeNode selectedNode1;

    String name;

    String type;

    String profile;

    String value;

    private String message;

    private static int max;

    public TreeNode getRoot1() {
        return root1;
    }

    public void setRoot1(TreeNode root1) {
        this.root1 = root1;
    }

    public TreeNode getSelectedNode1() {
        return selectedNode1;
    }

    public void setSelectedNode1(TreeNode selectedNode1) {
        this.selectedNode1 = selectedNode1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static int getMax() {
        return max;
    }

    public static void setMax(int max) {
        ProductView.max = max;
    }

    @PostConstruct
    public void init() {
        root1 = new DefaultTreeNode(new Product("Products", "", "", ""), null);

        TreeNode keysForHSMThales = new DefaultTreeNode(new Product("Keys 3DES for HSM Thales", "Application", "", ""), root1);

        TreeNode keysForHSMThalesHSMErrorTest = new DefaultTreeNode(new Product("Keys 3DES for HSM Thales HSM Error Test", "Application", "", ""), root1);

        TreeNode KeysRSAForHSMThalesAndVisa = new DefaultTreeNode(new Product("Keys RSA for HSM Thales and Visa", "Application", "", ""), root1);

        TreeNode keysForHSMThales1 = new DefaultTreeNode(new Product("LMK", "Tag", "Common", "Lmk-1"), keysForHSMThales);

        TreeNode keysForHSMThales2 = new DefaultTreeNode(new Product("PVKIBM3624", "Tag", "Common","Lmk-1"), keysForHSMThales);

        TreeNode keysForHSMThales3 = new DefaultTreeNode(new Product("DecimalizationTableHSR5234", "Tag", "Common","PVKIBM3624PVKIBM3624PVKIBM3624"), keysForHSMThales);

        maxLengthOfName(root1);
    }

    public static void maxLengthOfName(TreeNode root1) {
        List<TreeNode> children = root1.getChildren();

        if (children.size() == 0) {
            Product product = (Product)root1.getData();

            int nameLength = product.getName().length();
            if (nameLength > max) {
                max = nameLength;
            }
        }
        else {
            for (TreeNode node : children) {
                maxLengthOfName(node);
            }
        }
    }

    public void onDragDrop(TreeDragDropEvent event) {
        TreeNode dragNode = event.getDragNode();
        int dropIndex = event.getDropIndex();
    }

    public void onNodeSelect(NodeSelectEvent event) {
        Product product = (Product)event.getTreeNode().getData();

        this.value = product.getValue();
        this.name = product.getName();
        this.profile = product.getProfile();
        this.type = product.getType();

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + message) );
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    }



}
