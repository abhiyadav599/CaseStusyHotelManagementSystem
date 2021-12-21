import { TestBed } from '@angular/core/testing';

import { ReceptionGuardGuard } from './reception-guard.guard';

describe('ReceptionGuardGuard', () => {
  let guard: ReceptionGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ReceptionGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
