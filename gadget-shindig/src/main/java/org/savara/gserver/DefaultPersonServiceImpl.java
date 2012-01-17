/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008-12, Red Hat Middleware LLC, and others contributors as indicated
 * by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.savara.gserver;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.common.util.ImmediateFuture;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.protocol.RestfulCollection;
import org.apache.shindig.social.core.model.PersonImpl;
import org.apache.shindig.social.opensocial.model.Name;
import org.apache.shindig.social.opensocial.model.Person;
import org.apache.shindig.social.opensocial.spi.CollectionOptions;
import org.apache.shindig.social.opensocial.spi.GroupId;
import org.apache.shindig.social.opensocial.spi.PersonService;
import org.apache.shindig.social.opensocial.spi.UserId;
import org.savara.gserver.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * @author: Jeff Yu
 * @date: 17/01/12
 */
public class DefaultPersonServiceImpl implements PersonService{

    @PersistenceContext
    private EntityManager entityManager;

    public Future<RestfulCollection<Person>> getPeople(Set<UserId> userIds, GroupId groupId, CollectionOptions collectionOptions, Set<String> strings, SecurityToken securityToken) throws ProtocolException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Future<Person> getPerson(UserId userId, Set<String> strings, SecurityToken securityToken) throws ProtocolException {
        String uid = userId.getUserId();
        User user = entityManager.find(User.class, Long.valueOf(uid));
        Person p = new PersonImpl();
        p.setDisplayName(user.getDisplayName());
        p.setId(String.valueOf(user.getId()));
        return ImmediateFuture.newInstance(p);
    }
}
