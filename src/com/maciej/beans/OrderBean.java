package com.maciej.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "order")
@SessionScoped
public class OrderBean implements Serializable{
    private List<String> lista = new ArrayList<String>();

    public String getNapis() {
        return napis;
    }

    private String napis = "WITAM ZIOMEK";

    public OrderBean() {
        lista.add("maciek");
        lista.add("wojtek");
        lista.add("daniel");
        lista.add("karolina");
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
	
	public static void main(String[] args) throws IOException {
        String docPieceNameDec = "com.networkedassets.autodoc.transformer.JavaDocGenerator";

        File file = new File("C:\\Users\\Maciek\\IdeaProjects\\JavaTests\\src\\main\\resources\\hugefuckingjson.json");
        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(file);
        JsonNode entitiesNode = rootNode.get("entities");
        JsonNode relationsNode = rootNode.get("relations");

        List<Relation> relationList = mapper.readValue(relationsNode.toString(), new TypeReference<List<Relation>>(){});
        relationList.forEach(System.out::println);

        Iterator<String> stringIterator = entitiesNode.fieldNames();
        String substringDocPieceNameDec = docPieceNameDec.substring(0, docPieceNameDec.lastIndexOf("."));
        while (stringIterator.hasNext()) {
            String packageName = stringIterator.next();
            if(packageName.startsWith(substringDocPieceNameDec) && packageName.length() == substringDocPieceNameDec.length()){
                System.out.println(packageName);
            }
        }
    }
}
