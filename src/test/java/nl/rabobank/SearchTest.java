package nl.rabobank;

import org.junit.Before;
import org.junit.Test;

public class SearchTest {
    
    private Search search;
    
    @Before
    public void init(){
        search = new Search();
    }
    
    
    @Test
    public void test(){
        search.search("#sachin");
    }

}
