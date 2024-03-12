import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignRequestListComponent } from './assign-request-list.component';

describe('AssignRequestListComponent', () => {
  let component: AssignRequestListComponent;
  let fixture: ComponentFixture<AssignRequestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignRequestListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssignRequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
