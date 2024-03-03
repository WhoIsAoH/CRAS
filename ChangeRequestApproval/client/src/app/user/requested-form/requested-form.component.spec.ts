import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestedFormComponent } from './requested-form.component';

describe('RequestedFormComponent', () => {
  let component: RequestedFormComponent;
  let fixture: ComponentFixture<RequestedFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RequestedFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RequestedFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
