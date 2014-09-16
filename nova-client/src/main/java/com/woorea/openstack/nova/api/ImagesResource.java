package com.woorea.openstack.nova.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Image;
import com.woorea.openstack.nova.model.Images;
import com.woorea.openstack.nova.model.Metadata;

/**
 * @author Naresh 
 * Class Image Resource for the Class OpenStackClient.
 */
public class ImagesResource {
    /**
     * Private Variable which is final and OpenStackClient Class. 
     */
    private final OpenStackClient CLIENT;
    /**
     * Constructor which gives the Client Value.
     * @param client of type OpenStackClient.
     */
    public ImagesResource(OpenStackClient client) {
        CLIENT = client;
    }
    /**
     * List Method which is of type boolean.
     * @param detail returns the boolean value.
     * @return detail in new list. 
     */
    public List list(boolean detail) {
        return new List(detail);
    }
    /**
     * Create Method of type Create which has parameter Image Class.
     * @param image gives the Image to create New Image.
     * @return new Image which is Created.
     */
    public Create create(Image image) {
        return new Create(image);
    }
    /**
     * Show Method of type Show which has parameter as Id. 
     * @param id gives the Id value.
     * @return Shows new Id value.
     */
    public Show show(String id) {
        return new Show(id);
    }
    /**
     * The Method showMetadata shows MetaData of the Client.
     * @param id gives the Id value of Client.
     * @return New ShowMetadata with Id value.
     */
    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }
    /**
     * Method for Deleting the Client detail using Id value.
     * @param id gives the Id value of Client. 
     * @return New Id which is deleted.
     */
    public Delete delete(String id) {
        return new Delete(id);
    }
    /**
     * Class List inherits the OpenStackRequest given by the Client and list is 
     * type of Images.
     */
    public class List extends OpenStackRequest < Images > {
        /**
         * The Method List is of type boolean which gives the detail of Client.
         * It depends on the base Class and Uses HttpMethod Get().
         * @param detail gives the Client Detail.
         */
        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/images/detail" : "/images",
                    null, Images.class);
        }
    }
    /**
     * Create Class inherits the OpenStackRequest given by the Client and gives
     * the Image as List.
     */
    public class Create extends OpenStackRequest < Image > { 
        /**
         * Private variable image of type Image.
         */
        private Image image;
        /**
         * Constructor Create creates Image, uses the HttpMethod Post() and
         * uses " this " Pointer to point private variable.
         * @param image passes Image.
         */
        public Create(Image image) {
            super(CLIENT, HttpMethod.POST, "/images", Entity.json(image),
                    Image.class);
            this.image = image;
        }	
    }
    /**
     * Class Show inherits the OpenStackRequest given by the Client as Image list
     */
    public class Show extends OpenStackRequest < Image > { 
        /**
         * Show Constructor gives the Client Id, depends on base Class and uses
         * HttpMethod Get(). 
         * @param id gives the Client Id.
         */
        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/images/")
                    .append(id).toString(), null, Image.class);
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
            super(CLIENT, HttpMethod.GET, new StringBuilder("/images/")
                    .append(id).append("/metadata").toString(), null,
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
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/images/")
                    .append(id).toString(), null, Void.class);
        }
    }
}
