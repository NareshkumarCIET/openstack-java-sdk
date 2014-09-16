package com.woorea.openstack.nova.api.extensions;

import java.util.Map;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.HostAggregate;
import com.woorea.openstack.nova.model.HostAggregates;
/**
 * @author Naresh
 * The Aggregates Extension gives the Extension for the OpenStack Nova Client.
 */
public class AggregatesExtension { 
    /**
     * The final Variable for the OpenStackClient Class.
     */
    private final OpenStackClient CLIENT;
    /**
     * Constructor for the AggregatesExtension Class and Pass the Client. 
     * @param client gives the Request of the Client.
     */
    public AggregatesExtension(OpenStackClient client) {
        CLIENT = client;
    }
    /**
     * The Method list() returns the List Class and 
     * @return New List() method.
     */
    public List list() {
        return new List();
    }
    /**
     * The Method showAggregate returns the ShowAggregate Class.
     * @param id gives the Client Id.
     * @return New Id of ShowAggregate Class.
     */
    public ShowAggregate showAggregate(String id) {
        return new ShowAggregate(id);
    }
    /**
     * UpdateAggregateMetadata updates the Aggregate Metadata when the Client 
     * gives OpenStack Client Request.
     * @param id gives the Client Id.
     * @param name gives the Client Name.
     * @param availabilityZone gives the Client WorkPlace.
     * @return new UpdateAggregateMetadata which is updated.
     */
    public UpdateAggregateMetadata updateAggregateMetadata(String id,
            String name, String availabilityZone) {
        return new UpdateAggregateMetadata(id, name, availabilityZone);
    }
    /**
     * The Method createAggregate creates Aggregate to the Client.
     * @param aggregateName gives the Updated Aggregate Name.
     * @param availabilityZoneName gives the Updated availability Zone. 
     * @return CreateAggregate which is New Aggregate Name and Zone Name.
     */
    public CreateAggregate createAggregate(String aggregateName,
            String availabilityZoneName) {
        return new CreateAggregate(aggregateName, availabilityZoneName);
    }
    /**
     * 
     * @param id
     * @return 
     */
    public DeleteAggregate deleteAggregate(String id) {
        return new DeleteAggregate(id);
    }
    /**
     * 
     * @param aggregateId
     * @param hostId
     * @return 
     */
    public AddHost addHost(String aggregateId, String hostId) {
        return new AddHost(aggregateId, hostId);
    }
    /**
     * 
     * @param aggregateId
     * @param hostId
     * @return 
     */
    public RemoveHost removeHost(String aggregateId, String hostId) {
        return new RemoveHost(hostId, aggregateId);
    }
    /**
     * 
     * @param aggregateId
     * @param key
     * @param value
     * @return 
     */
    public SetMetadata setMetadata(String aggregateId,
            String key, String value) {
        return new SetMetadata(aggregateId, key, value);
    }
    /**
     * 
     */
    public class List extends OpenStackRequest < HostAggregates > {
        /**
         * 
         */
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-aggregates",
                    null,
                    HostAggregates.class);
        }
    }
    /**
     * 
     */
    public class ShowAggregate extends OpenStackRequest < HostAggregate > {
        /**
         * 
         * @param id 
         */
        public ShowAggregate(String id) {
            super(CLIENT, HttpMethod.GET,
                    new StringBuffer("/os-aggregates/").append(id),
                    null,
                    HostAggregate.class);
        }
    }
    /**
     * 
     */
    public class UpdateAggregateMetadata extends 
            OpenStackRequest < HostAggregate > {
        /**
         * 
         * @param id
         * @param name
         * @param availabilityZone 
         */
        public UpdateAggregateMetadata(String id,
                String name, String availabilityZone) {
            super(CLIENT, HttpMethod.PUT,
                    new StringBuffer("/os-aggregates/").append(id),
                    availabilityZone == null
                    ? Entity.json("{\"aggregate\": {\"name\": \"" + name + "\" }}")
                    : Entity.json("{\"aggregate\": {\"name\": \""
                            + name
                            + "\", \"availability_zone\": \""
                            + availabilityZone
                            + "\" }}"),
                    HostAggregate.class);
        }
    }
    /**
     * 
     */
    public class CreateAggregate extends OpenStackRequest < HostAggregate > {
        /**
         * 
         * @param name
         * @param availabilityZone 
         */
        public CreateAggregate(String name, String availabilityZone) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuffer("/os-aggregates"),
                    availabilityZone == null
                    ? Entity.json("{\"aggregate\": {\"name\": \""
                            + name
                            + "\", \"availability_zone\": null }}")
                    : Entity.json("{\"aggregate\": {\"name\": \""
                            + name
                            + "\", \"availability_zone\": \""
                            + availabilityZone
                            + "\" }}"),
                    HostAggregate.class);
        }
    }
    /**
     * 
     */
    public class DeleteAggregate extends OpenStackRequest < Void > {
        /**
         * 
         * @param id 
         */
        public DeleteAggregate(String id) {
            super(CLIENT, HttpMethod.DELETE,
                    new StringBuffer("/os-aggregates/").append(id),
                    null,
                    null);
        }
    }
    /**
     * 
     */
    public class AddHost extends OpenStackRequest < HostAggregate > {
        /**
         * 
         * @param aggregateId
         * @param hostId 
         */
        public AddHost(String aggregateId, String hostId) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuffer("/os-aggregates/")
                    .append(aggregateId).append("/action"),
                    Entity.json("{\"add_host\": {\"host\": \""
                            + hostId + "\" }}"),
                    HostAggregate.class);
        }
    }
    /**
     * 
     */
    public class RemoveHost extends OpenStackRequest < HostAggregate > {
        /**
         * 
         * @param hostId
         * @param aggregateId 
         */
        public RemoveHost(String hostId, String aggregateId) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuffer("/os-aggregates/")
                    .append(aggregateId).append("/action"),
                    Entity.json("{\"remove_host\": {\"host\": \""
                            + hostId + "\" }}"),
                    HostAggregate.class);
        }
    }
    /**
     * 
     */
    public class SetMetadata extends OpenStackRequest < HostAggregate > {
        /**
         * 
         * @param aggregateId
         * @param key
         * @param value 
         */
        public SetMetadata(String aggregateId, String key, String value) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuffer("/os-aggregates/")
                    .append(aggregateId).append("/action"),
                    Entity.json("{\"set_metadata\": {\"metadata\": { \""
                            + key + "\": \"" + value + "\" }}}"),
                    HostAggregate.class);
        }
    }
}
