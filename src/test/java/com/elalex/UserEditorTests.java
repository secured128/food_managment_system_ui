package com.elalex;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.argThat;

@RunWith(MockitoJUnitRunner.class)
public class UserEditorTests {

	private static final String NAME = "ella";
	private static final String PASSWORD = "ella";

	@Mock
	UserRESTCaller userRESTCaller;
	@InjectMocks UserEditor editor;

	@Test
	public void shouldStoreUserInRepoWhenEditorSaveClicked() {
		this.editor.name.setValue(NAME);
		this.editor.password.setValue(PASSWORD);
		userDataWasFilled();

		this.editor.save.click();

//		then(this.userRESTCaller).should().save(argThat(userMatchesEditorFields()));
	}

	@Test
	public void shouldDeleteUserFromRepoWhenEditorDeleteClicked() {
		this.editor.name.setValue(NAME);
		this.editor.password.setValue(PASSWORD);
		userDataWasFilled();

		editor.delete.click();

//		then(this.userRESTCaller).should().delete(argThat(userMatchesEditorFields()));
	}

	private void userDataWasFilled() {
		this.editor.editUser(new User(NAME, PASSWORD));
	}

	private TypeSafeMatcher<User> userMatchesEditorFields() {
		return new TypeSafeMatcher<User>() {
			@Override
			public void describeTo(Description description) {}

			@Override
			protected boolean matchesSafely(User item) {
				return NAME.equals(item.getName()) && PASSWORD.equals(item.getPassword());
			}
		};
	}

}
