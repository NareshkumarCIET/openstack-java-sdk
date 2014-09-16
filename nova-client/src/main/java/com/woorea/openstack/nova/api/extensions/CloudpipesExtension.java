package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Cloudpipe;
import com.woorea.openstack.nova.model.Cloudpipes;
/**
 * 
 * @author Naresh
 */
public class CloudpipesExtension {
    /**
     * 
     */
    private final OpenStackClient CLIENT;
    /**
     * 
     * @param client 
     */
    public CloudpipesExtension(OpenStackClient client) {
        CLIENT = client;
    }
    /**
     * 
     * @return 
     */
    public List list() {
        return new List();
    }
    /**
     * 
     * @param cloudpipe
     * @return 
     */
    public Create create(Cloudpipe cloudpipe) {
        return new Create(cloudpipe);
    }
    /**
     * 
     */
    public class List extends OpenStackRequest < Cloudpipes > {
        /**
         * 
         */
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-cloudpipes", null,
                    Cloudpipes.class);
        }
    }
    /**
     * 
     */
    public class Create extends OpenStackRequest < Cloudpipe > {
        /**
         * 
         */
        private Cloudpipe cloudpipe;
        /**
         * 
         * @param cloudpipe 
         */
        public Create(Cloudpipe cloudpipe) {
            super(CLIENT, HttpMethod.POST, "/os-cloudpipes",
                    Entity.json(cloudpipe), Cloudpipe.class);
            this.cloudpipe = cloudpipe;
        }
    }
}
