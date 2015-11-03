/*
 * Copyright 2008-2009 the original 赵永春(zyc@hasor.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hasor.core.context;
import java.io.IOException;
import java.net.URISyntaxException;
import net.hasor.core.Environment;
import net.hasor.core.Hasor;
/**
 * 负责创建和维护{@link DataContext}。
 * @version : 2013-4-9
 * @author 赵永春 (zyc@hasor.net)
 */
public class StatusAppContext<CD extends DataContext> extends TemplateAppContext<CD> {
    private CD dataContext = null;
    public StatusAppContext(CD dataContext) throws IOException, URISyntaxException {
        this.dataContext = Hasor.assertIsNotNull(dataContext);
    }
    public StatusAppContext(DataContextCreater<CD> creater, Environment env) throws Throwable {
        this.dataContext = Hasor.assertIsNotNull(creater.create(env));
    }
    @Override
    protected CD getDataContext() {
        return this.dataContext;
    }
}