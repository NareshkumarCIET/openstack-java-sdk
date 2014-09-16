package com.woorea.openstack.nova.api.extensions;

import java.util.HashMap;
import java.util.Map;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.FloatingIp;
import com.woorea.openstack.nova.model.FloatingIps;
/**
 * 
 * @author Naresh
 */
public class FloatingIpsExtension {
    /**
     * 
     */
    private final OpenStackClient CLIENT;
    /**
     * 
     * @param client 
     */
    public FloatingIpsExtension(OpenStackClient client) {
        CLIENT = client;
    }
    /**
     * 
     */
    public class List extends OpenStackRequest < FloatingIps > {

        public List() {
            super(CLIENT, HttpMethod.GET, "/os-floating-ips", null, 
                    FloatingIps.class);
        }
    }
    /**
     * 
     */
    public class Allocate extends OpenStackRequest < FloatingIp > {
        /**
         * 
         * @param entity 
         */
        public Allocate(Entity < ? > entity) {
            super(CLIENT, HttpMethod.POST, "/os-floating-ips", entity, 
                    FloatingIp.class);
        }
    }
    /**
     * 
     */
    public class Deallocate extends OpenStackRequest < Void > {
        /**
         * 
         * @param id 
         */
        public Deallocate(String id) {
            super(CLIENT, HttpMethod.DELETE, 
                    new StringBuffer("/os-floating-ips/").append(id).toString(),
                    null, Void.class);
        }
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
     * @param pool
     * @return 
     */
    public Allocate allocate(String pool) {
        Entity < ? > entity = null;
        if (pool != null) {
            Map < String, String > body = new HashMap < String, String > ();
            body.put("pool", pool);
            entity = Entity.json(body);
        }
        return new Allocate(entity);
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Deallocate deallocate(String id) {
        return new Deallocate(id);
    }
}
