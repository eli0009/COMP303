package code;

public class Visitor {
    public static void main(String[] args) {
        Website[] sites = {
                new NormalSite("www.github.com"),
                new CloudflaredSite("www.google.com"),
        };

        WebsiteVisitor visitor = new SiteVisitor();

        for (Website site : sites) {
            site.accept(visitor);
        }
    }
}

interface WebsiteVisitor {

    void visit(NormalSite site);

    void visit(CloudflaredSite site);

}

class SiteVisitor implements WebsiteVisitor {

    @Override
    public void visit(NormalSite site) {
        System.out.println("Visiting site " + site.getName() + ", no verification needed");
    }

    @Override
    public void visit(CloudflaredSite site) {
        System.out.println("Visiting Cloudflare protected site " + site.getName() + ", bypassing Cloudflare...");
    }
}

abstract class Website {

    private String name;

    public Website(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void accept(WebsiteVisitor visitor);
}

class NormalSite extends Website {

    public NormalSite(String name) {
        super(name);
    }

    @Override
    public void accept(WebsiteVisitor visitor) {
        visitor.visit(this);
    }
}

class CloudflaredSite extends Website {

    public CloudflaredSite(String name) {
        super(name);
    }

    @Override
    public void accept(WebsiteVisitor visitor) {
        visitor.visit(this);
    }
}