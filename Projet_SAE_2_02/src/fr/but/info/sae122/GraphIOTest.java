package src.fr.but.info.sae122;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class GraphIOTest {


    @Test
    public void WriteTest() throws AddNodeException {
        Graph g = new Graph();
        g.addNode("N1");
        g.addNode("N2");
    }

    @Test
    public void ReadTest() throws AddNodeException {

    }
}