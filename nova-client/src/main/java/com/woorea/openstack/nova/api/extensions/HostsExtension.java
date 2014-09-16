package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Host;
import com.woorea.openstack.nova.model.Hosts;
/**
 * 
 * @author Naresh
 */
public class HostsExtension {
    /**
     * 
     */
    private final OpenStackClient CLIENT;
    /**
     * 
     * @param client 
     */
    public HostsExtension(OpenStackClient client) {
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
     * @param id
     * @return 
     */
    public Show show(String id) {
        return new Show(id);
    }
    /**
     * 
     */
    public class List extends OpenStackRequest < Hosts > {
        /**
         * 
         */
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-hosts", null,
                    Hosts.class);
        }
    }
    /**
     * 
     */
    public class Show extends OpenStackRequest < Host > {
        /**
         * 
         * @param id 
         */
        public Show(String id) {
            super(CLIENT, HttpMethod.GET,
                    new StringBuffer("/os-hosts/").append(id)
                    .toString(), null, Host.class);
        }
    }
}
