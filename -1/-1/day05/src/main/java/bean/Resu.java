package bean;

import java.util.List;

public class Resu {
    public String message;
    public String status;
    public List<Result> result;

    public class Result{
            public String commodityName;
            public String masterPic;
            public String price;
    }
}
