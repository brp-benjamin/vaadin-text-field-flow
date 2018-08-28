/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.component.textfield.demo;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.GeneratedVaadinTextField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

/**
 * View for {@link GeneratedVaadinTextField} demo.
 *
 * @author Vaadin Ltd
 */
@Route("vaadin-text-field")
public class TextFieldView extends DemoView {

    private class ViewModel {
        public ViewModel(String val) {
            setValue(val);
        }

        private String value;

        public String getValue() {
            return this.value;
        }

        public void setValue(String val) {
            this.value = val;
        }
    }

    private ViewModel model;
    private Binder<ViewModel> b;

    @Override
    public void initView() {
        addProblemCard();
        addWorkingCard();
    }

    private void addProblemCard() {
        Div message = new Div();

        // begin-source-example
        // source-example-heading: Demo of problem
        model = new ViewModel("initial value");
        b = new Binder<ViewModel>();

        TextField textField = new TextField();
        textField.addValueChangeListener(event -> message.setText(
                String.format("Text field value changed from '%s' to '%s'",
                        event.getOldValue(), event.getValue())));

        b.forField(textField).asRequired().bind(ViewModel::getValue, ViewModel::setValue);
        b.setBean(model);
        // end-source-example

        addCard("Demo of problem", textField, message);
    }

    private void addWorkingCard() {
        Div message = new Div();

        // begin-source-example
        // source-example-heading: Working correctly without bindings
        TextField textField = new TextField();
        textField.setRequired(true);
        textField.addValueChangeListener(event -> message.setText(
                String.format("Text field value changed from '%s' to '%s'",
                        event.getOldValue(), event.getValue())));
        // end-source-example

        addCard("Working correctly without bindings", textField, message);
    }
}
