package com.sevenbits.file_list.task2;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserManagerTest {
    UserManager manager;
    ICollection collection = mock(ICollection.class);

    @Test
    public void getUserByIndexTest() throws UserManagerException, IOException {
        manager = new UserManager(collection);
        manager.createDefault("Bob");
        when(collection.get(1)).thenReturn(new User("Bob", "default"));
        User user = manager.getUserByIndex(1);
        assertEquals("Bob", user.getName());
    }

    @Test (expected = UserManagerException.class)
    public void getUserByIndexTestWithException() throws UserManagerException, IOException {
        manager = new UserManager(collection);
        doThrow(new IOException())
                .when(collection)
                .get(anyLong());
        manager.getUserByIndex(1);
    }


    @Test
    public void createDefaultTest() throws UserManagerException, IOException {
        manager = new UserManager(collection);
        manager.createDefault("Bob");
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                User user = invocationOnMock.getArgument(0);
                assertEquals("Bob", user.getName());
                assertEquals("default", user.getRole());
                return null;
            }
        }).when(collection).add(any(User.class));
    }

    @Test (expected = UserManagerException.class)
    public void createDefaultTestWithException() throws UserManagerException, IOException {
        manager = new UserManager(collection);
        doThrow(new IOException())
                .when(collection)
                .add(any(User.class));
        manager.createDefault("Bob");
    }
}
