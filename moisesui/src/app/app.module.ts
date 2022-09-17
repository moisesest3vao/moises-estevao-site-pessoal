import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutComponent } from './about/about.component';
import { SkillsComponent } from './skills/skills.component';
import { ContactComponent } from './contact/contact.component';
import { HeaderComponent } from './header/header.component';
import { ReferencesComponent } from './references/references.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { HomeComponent } from './home/home.component';
import { TranslateModule } from '@ngx-translate/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CommonModule } from '@angular/common';
import { MatRadioModule } from '@angular/material/radio';
import { FormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxMaskModule } from 'ngx-mask'
import { RecaptchaModule } from 'ng-recaptcha'


@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    SkillsComponent,
    ContactComponent,
    HeaderComponent,
    ReferencesComponent,
    HomeComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    TranslateModule,
    BrowserAnimationsModule,
    MatRadioModule,
    FormsModule,
    MatSelectModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    RecaptchaModule,
    TranslateModule.forRoot(),
    NgxMaskModule.forRoot({
      dropSpecialCharacters : false
    }),
  ],
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
