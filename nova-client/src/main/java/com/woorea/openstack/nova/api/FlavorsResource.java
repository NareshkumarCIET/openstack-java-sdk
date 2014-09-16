package com.woorea.openstack.nova.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Flavor;
import com.woorea.openstack.nova.model.Flavors;
import com.woorea.openstack.nova.model.Metadata;

/**
 * @author Naresh Class for the FlavoursResource allocation which is for
 * OpenStackClient.
 */
public class FlavorsResource {

    /**
     * Final Variable for the OpenStackClient Class.
     */
    private final OpenStackClient CLIENT;

    /**
     * Parameterized Constructor which has parameter as Client.
     * @param client gives the Client Request.
     */
    public FlavorsResource(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * Method List which has return type of Boolean.
     * @param detail which has Client detail.
     * @return new list of Client detail.
     */
    public List list(boolean detail) {
        return new List(detail);
    }
    /**
     * Method Create for Flavor Class and has parameter of flavor.
     * @param flavor gives the flavor detail.
     * @return new flavor variable for create method.
     */
    public Create create(Flavor flavor) {
        return new Create(flavor);
    }
    /**
     * Method Show for Flavor Class and pass the id value.
     * @param id gives id of Client.
     * @return Shows new id value.
     */
    public Show show(String id) {
        return new Show(id);
    }
    /**
     * Method showMetadata for Flavor Class and pass the id value.
     * @param id gives id of Client.
     * @return MetaData as new id value.
     */
    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }

    /**
     * Method Delete for Flavor Class and pass the id value.
     * @param id gives id of Client.
     * @return deleted id value.
     */
    public Delete delete(String id) {
        return new Delete(id);
    }

    /**
     * Class list inherits the OpenStackRequest given by the Client and pass to
     * the Flavors Class.
     */
    public class List extends OpenStackRequest < Flavors > {

        /**
         * Parameterized Constructor for the list Class and return type of
         * boolean.
         * @param detail given by the Client. The method List depends on the
         * Base Class.
         */
        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/flavors/detail"
                    : "/flavors", null, Flavors.class);
        }
    }

    /**
     * Class Create inherits the OpenStackRequest given by the Client and pass
     * to the Flavors Class.
     */
    public class Create extends OpenStackRequest < Flavor > {
        /**
         * Private variable for Flavor and present only in the Create method.
         */
        private Flavor flavor;
        /**
         * Constructor for the Create Class and has the parameter of return type
         * Flavor and Calls the HttpMethod "POST".
         * @param flavor to point the Flavor Class. flavor points to the "this"
         * pointer.
         */
        public Create(Flavor flavor) {
            super(CLIENT, HttpMethod.POST, "/flavors", Entity.json(flavor), 
                    Flavor.class);
            this.flavor = flavor;
        }
    }

    /**
     * Class Show inherits the OpenStackRequest given by the Client and pass to
     * the Flavors Class.
     */
    public class Show extends OpenStackRequest < Flavor > {
        /**
         * Method Show is used to show the id value of the Client, it is
         * Constructor and depends on the Base Class.
         * @param id gives the Client Id.
         */
        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/flavors/").
                    append(id).toString(), null, Flavor.class);
        }
    }
    /**
     * Class ShowMetadata inherits the OpenStackRequest given by the Client and
     * has the Metadata information.
     */
    public class ShowMetadata extends OpenStackRequest < Metadata > {

        /**
         * Constructor method of ShowMetadata and depends on the Base Class.
         * @param id gives the Client Id.
         */
        public ShowMetadata(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/flavors/").
                    append(id).append("/metadata").toString(), null,
                    Metadata.class);
        }
    }
    /**
     * Class Delete inherits the OpenStackRequest given by the Client and
     * deletes the Request given by the Client.
     */
    public class Delete extends OpenStackRequest < Void > {

        /**
         * Constructor method of Delete and Calls the HttpMethod of Delete.
         * @param id gives the Client Id.
         */
        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/flavors/").
                    append(id).toString(), null, Void.class);
        }
    }
}
