/*
 * MIT License
 *
 * Copyright (c) 2019 Fatih Bozik
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.fatihbozik.licencegenerator.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.DumbAware;
import io.github.fatihbozik.licencegenerator.file.Licence;
import org.jetbrains.annotations.NotNull;

import static io.github.fatihbozik.licencegenerator.LicenceGeneratorBundle.message;

/**
 * Creates new file or returns existing one.
 *
 * @author Fatih Bozik <bozikfatih@gmail.com>
 * @since 0.0.1
 */
public class NewFileAction extends AnAction implements DumbAware {
    private final Licence licence;

    NewFileAction(@NotNull Licence licence) {
        this.licence = licence;
        createPresentation(licence);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

    }

    private void createPresentation(@NotNull Licence aLicence) {
        final Presentation templatePresentation = getTemplatePresentation();
        templatePresentation.setText(aLicence.getName());
        templatePresentation.setDescription(message("action.newFile.description", licence.getName()));
    }
}
