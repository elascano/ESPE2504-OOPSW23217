

package ec.edu.espe.strategy.view;

import ec.edu.espe.strategy.controller.SortingContext;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public class SortApp {

    public static void main(String[] args) {
        SortingContext context =new SortingContext();
        int[]data={-1,0,45,2,1,7,8,9,12};
        context.sortArray(data);
    }
}
