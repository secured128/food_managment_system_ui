package com.elalex;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.BDDAssertions.*;

import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.boot.VaadinAutoConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VaadinUITests.Config.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class VaadinUITests {

	@Autowired
	UserRESTCaller repository;

	VaadinRequest vaadinRequest = Mockito.mock(VaadinRequest.class);

	UserEditor editor;

	VaadinUI vaadinUI;

	@Before
	public void setup() {
		this.editor = new UserEditor(this.repository);
		this.vaadinUI = new VaadinUI(this.repository, editor);
	}

//	@Test
//	public void shouldInitializeTheGridWithUserRepositoryData() {
//		int userCount = (int) this.repository.count();
//
//		vaadinUI.init(this.vaadinRequest);
//
//		then(vaadinUI.grid.getColumns()).hasSize(3);
//		then(getUsersInGrid()).hasSize(userCount);
//	}

	private List<User> getUsersInGrid() {
		ListDataProvider<User> ldp = (ListDataProvider) vaadinUI.grid.getDataProvider();
		return new ArrayList<>(ldp.getItems());
	}

//	@Test
//	public void shouldFillOutTheGridWithNewData() {
//		int initialUserCount = (int) this.repository.count();
//		this.vaadinUI.init(this.vaadinRequest);
//		userDataWasFilled(editor, "Marcin", "Grzejszczak");
//
//		this.editor.save.click();
//
//		then(getUsersInGrid()).hasSize(initialUserCount + 1);
//
//		then(getUsersInGrid().get(getUsersInGrid().size() - 1))
//			.extracting("name", "password")
//			.containsExactly("Marcin", "Grzejszczak");
//
//	}

//	@Test
//	public void shouldFilterOutTheGridWithTheProvidedLastName() {
//		this.vaadinUI.init(this.vaadinRequest);
//		this.repository.save(new User("Josh", "Long"));
//
//		vaadinUI.listUsers("Long");
//
//		then(getUsersInGrid()).hasSize(1);
//		then(getUsersInGrid().get(getUsersInGrid().size() - 1))
//			.extracting("name", "password")
//			.containsExactly("Josh", "Long");
//	}

	@Test
	public void shouldInitializeWithInvisibleEditor() {
		this.vaadinUI.init(this.vaadinRequest);

		then(this.editor.isVisible()).isFalse();
	}

	@Test
	public void shouldMakeEditorVisible() {
		this.vaadinUI.init(this.vaadinRequest);
		User first = getUsersInGrid().get(0);
		this.vaadinUI.grid.select(first);

		then(this.editor.isVisible()).isTrue();
	}

	private void userDataWasFilled(UserEditor editor, String name,
			String password) {
		this.editor.name.setValue(name);
		this.editor.password.setValue(password);
		editor.editUser(new User(name, password));
	}

	@Configuration
	@EnableAutoConfiguration(exclude = VaadinAutoConfiguration.class)
	static class Config {

		@Autowired
		UserRESTCaller repository;

		@PostConstruct
		public void initializeData() {
//			this.repository.save(new User("Jack", "Bauer"));
//			this.repository.save(new User("Chloe", "O'Brian"));
//			this.repository.save(new User("Kim", "Bauer"));
//			this.repository.save(new User("David", "Palmer"));
//			this.repository.save(new User("Michelle", "Dessler"));
		}
	}
}
